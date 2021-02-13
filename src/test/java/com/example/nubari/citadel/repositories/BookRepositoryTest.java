package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Author;
import com.example.nubari.citadel.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;


@DataMongoTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    Author savedAuthor;
    @BeforeEach
    void setUp() {
        Author sampleAuthor = new Author();
        sampleAuthor.setFirstname("Sample");
        sampleAuthor.setLastname("Author");
        savedAuthor = authorRepository.save(sampleAuthor);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testRepositorySaveMethod(){
        Book book = new Book();
        book.setCoverImage("SampleCoverImage");
        book.setLink("SampleLink");
        book.setSummary("SampleSummary");
        book.setTitle("SampleTitle");
        book.setPublishDate(LocalDateTime.of(2020, 1,27,0,0));
        book.setAuthor(savedAuthor);
        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getId());
        assertEquals("SampleLink", savedBook.getLink());
        assertEquals("SampleCoverImage", savedBook.getCoverImage());
        assertEquals("SampleSummary", savedBook.getSummary());
        assertEquals("SampleTitle", savedBook.getTitle());
        assertEquals(LocalDateTime.of(2020, 1, 27, 0,0), savedBook.getPublishDate());
    }
    @Test
    void findBooksPublishedAfterACertainDate() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setPublishDate(LocalDateTime.of(2012, 1,27,0,0));
        book2.setPublishDate(LocalDateTime.of(2020, 1,1,0,0));
        book3.setPublishDate(LocalDateTime.of(2009, 1, 1,0,0));
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        List<Book> booksPublishedAfter2010 =
                bookRepository.findBookByPublishDateAfter(LocalDateTime.of(2010, 1,1,0,0));
        assertEquals(2, booksPublishedAfter2010.size());
        assertTrue(booksPublishedAfter2010.contains(book1));
        assertTrue(booksPublishedAfter2010.contains(book2));

    }

    @Test
    void findBookPublishedBeforeACertainDate() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setPublishDate(LocalDateTime.of(2012, 1,27,0,0));
        book2.setPublishDate(LocalDateTime.of(2020, 1,1,0,0));
        book3.setPublishDate(LocalDateTime.of(2009, 1, 1,0,0));
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        List<Book> booksPublishedBefore2010 =
                bookRepository.findBookByPublishDateBefore(LocalDateTime.of(2010, 1,1,0,0));
        assertEquals(1, booksPublishedBefore2010.size());
        assertTrue(booksPublishedBefore2010.contains(book3));
    }
    @Test
    void testFindBooksByTitle(){
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        book1.setTitle("Test Title");
        book2.setTitle("Test Title 2");
        book3.setTitle("A Lagos story");
        book4.setTitle("Test ing");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        Pageable paging = PageRequest.of(0, 1);
        Slice<Book> firstPage = bookRepository.findBooksByTitleContaining("Test", paging);
        assertEquals(1,firstPage.getSize());
        List<Book> booksOnFirstPage = firstPage.getContent();

    }

}
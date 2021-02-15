package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Author;
import com.example.nubari.citadel.models.Book;
import com.example.nubari.citadel.models.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


@DataMongoTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    GenreRepository genreRepository;
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
        bookRepository.deleteAll();
    }

    @Test
    void testRepositorySaveMethod() {
        Book book = new Book();
        book.setCoverImage("SampleCoverImage");
        book.setLink("SampleLink");
        book.setSummary("SampleSummary");
        book.setTitle("SampleTitle");
        book.setPublishDate(LocalDate.of(2020, 1, 27));
        book.setAuthor(savedAuthor);
        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getId());
        assertEquals("SampleLink", savedBook.getLink());
        assertEquals("SampleCoverImage", savedBook.getCoverImage());
        assertEquals("SampleSummary", savedBook.getSummary());
        assertEquals("SampleTitle", savedBook.getTitle());
        assertEquals(LocalDate.of(2020, 1, 27), savedBook.getPublishDate());
    }

    @Test
    void findBooksPublishedAfterACertainDate() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setPublishDate(LocalDate.of(2012, 1, 27));
        book2.setPublishDate(LocalDate.of(2020, 1, 1));
        book3.setPublishDate(LocalDate.of(2009, 1, 2));
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        Pageable paging = PageRequest.of(0, 3);
        Slice<Book> booksPublishedAfter2010 =
                bookRepository.findBookByPublishDateAfter(LocalDate.of(2010, 1, 1
                ), paging);
        assertEquals(2, booksPublishedAfter2010.getContent().size());
        assertTrue(booksPublishedAfter2010.getContent().contains(book1));
        assertTrue(booksPublishedAfter2010.getContent().contains(book2));
    }

    @Test
    void findBookPublishedBeforeACertainDate() {
        Book book1 = new Book();
        book1.setTitle("Test");
        Book book2 = new Book();
        book2.setTitle("Test2");
        Book book3 = new Book();
        book3.setTitle("Test3");
        book1.setPublishDate(LocalDate.of(2012, 1, 27));
        book2.setPublishDate(LocalDate.of(2020, 1, 1));
        book3.setPublishDate(LocalDate.of(2009, 1, 1));
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        Pageable paging = PageRequest.of(0, 3);
        Slice<Book> booksPublishedBefore2010 =
                bookRepository.findBookByPublishDateBefore(LocalDate.of(2010, 1, 1), paging);
        assertEquals(1, booksPublishedBefore2010.getContent().size());
        for (Book book : booksPublishedBefore2010.getContent()) {
            System.out.println("Test");
            System.out.println(book);

        }
        assertTrue(booksPublishedBefore2010.getContent().contains(book3));
    }

    @Test
    void testFindBooksByTitle() {
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
        Pageable paging = PageRequest.of(0, 2);
        Slice<Book> firstPage = bookRepository.findBooksByTitleContaining("Test", paging);
        List<Book> booksOnFirstPage = firstPage.getContent();
        assertEquals(2, booksOnFirstPage.size());
        assertEquals(book1, booksOnFirstPage.get(0));
        assertEquals(book2, booksOnFirstPage.get(1));
        Pageable paging2 = PageRequest.of(1, 2);
        Slice<Book> secondPage = bookRepository.findBooksByTitleContaining("Test", paging2);
        List<Book> booksOnSecondPage = secondPage.getContent();
        assertEquals(1, booksOnSecondPage.size());
        assertEquals(book4, booksOnSecondPage.get(0));
    }

    @Test
    void testFindBookByGenre() {
        Genre genre1 = new Genre();
        genre1.setName("Fiction");
        Genre genre2 = new Genre();
        genre2.setName("Fantasy");
        Genre fictionGenre = genreRepository.save(genre1);
        Genre fantasyGenre = genreRepository.save(genre2);
        Book book1 = new Book();
        book1.setGenre(fantasyGenre);
        book1.setTitle("Test");
        Book book2 = new Book();
        book2.setGenre(fictionGenre);
        book2.setTitle("Test2");
        bookRepository.save(book1);
        bookRepository.save(book2);
        Pageable paging = PageRequest.of(0, 1);
        Slice<Book> matchingBooks = bookRepository.findBooksByGenre(fantasyGenre, paging);
        assertEquals(1, matchingBooks.getContent().size());
        assertEquals(book1, matchingBooks.getContent().get(0));
    }

}
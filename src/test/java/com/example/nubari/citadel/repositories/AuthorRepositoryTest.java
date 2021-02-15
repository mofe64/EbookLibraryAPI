package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;
    Author author1;
    Author author2;
    Author author3;

    @BeforeEach
    void setUp() {
        author1 = new Author();
        author1.setFirstname("Max");
        author1.setLastname("Steel");
        author2 = new Author();
        author2.setFirstname("Maximus");
        author2.setLastname("Test");
        author3 = new Author();
        author3.setFirstname("Moe");
        author3.setLastname("Joe");
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
    }

    @AfterEach
    void tearDown() {
        authorRepository.deleteAll();
    }

    @Test
    void testAuthorRepositorySaveMethod() {
        Author author = new Author();
        author.setFirstname("Test");
        author.setLastname("Test");
        Author savedAuthor = authorRepository.save(author);
        assertNotNull(savedAuthor.getId());
        assertEquals("Test", savedAuthor.getFirstname());
        assertEquals("Test", savedAuthor.getLastname());
    }

    @Test
    void findAuthorByFirstnameStartingWith() {
        Pageable paging = PageRequest.of(0, 2);
        Slice<Author> authorsFirstPage = authorRepository.findAuthorByFirstnameStartingWith("Max", paging);
        assertEquals(2, authorsFirstPage.getContent().size());
        assertEquals(author1, authorsFirstPage.getContent().get(0));
        assertEquals(author2, authorsFirstPage.getContent().get(1));
    }

    @Test
    void findAuthorByFirstname() {
    }

    @Test
    void findAuthorByLastname() {
    }

}
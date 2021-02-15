package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class GenreRepositoryTest {
    @Autowired
    GenreRepository genreRepository;
    Genre genre1;
    Genre genre2;
    @BeforeEach
    void setUp() {
        genre1 = new Genre();
        genre2 = new Genre();
        genre1.setName("Test");
        genre2.setName("Hello");

    }

    @AfterEach
    void tearDown() {
        genreRepository.deleteAll();
    }

    @Test
    void findGenreByName() {
        genreRepository.save(genre1);
        genreRepository.save(genre2);
        Optional<Genre> genreOptional = genreRepository.findGenreByName("Test");
        assertTrue(genreOptional.isPresent());
        assertEquals(genre1, genreOptional.get());
    }
}
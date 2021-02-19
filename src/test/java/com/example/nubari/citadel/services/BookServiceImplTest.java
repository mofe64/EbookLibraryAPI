package com.example.nubari.citadel.services;

import com.example.nubari.citadel.repositories.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void test(){}
}
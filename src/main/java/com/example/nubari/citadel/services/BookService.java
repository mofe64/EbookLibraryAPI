package com.example.nubari.citadel.services;

import com.example.nubari.citadel.dtos.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;
import java.util.Optional;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    Optional<BookDTO> getBookByTitle(String title);
    Optional<BookDTO> getBookByAuthor(String authorName);
    Optional<BookDTO> getBookByPublishDate(LocalDate publishDate);
    Slice<BookDTO> getBooksPublishedBefore(LocalDate publishDate, Pageable pageable);
    Slice<BookDTO> getBooksPublishedAfter(LocalDate publishDate, Pageable pageable);
    Slice<BookDTO> getAllBooks(Pageable pageable);
    Slice<BookDTO> getBooksByGenre(String genreName, Pageable pageable);
    Slice<BookDTO> searchBooksFor(String searchQuery, Pageable pageable);
    void deleteBook(String bookTitle);
}

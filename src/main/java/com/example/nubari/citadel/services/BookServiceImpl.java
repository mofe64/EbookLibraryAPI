package com.example.nubari.citadel.services;

import com.example.nubari.citadel.dtos.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;
import java.util.Optional;

public class BookServiceImpl implements BookService{
    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public Optional<BookDTO> getBookByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<BookDTO> getBookByAuthor(String authorName) {
        return Optional.empty();
    }

    @Override
    public Optional<BookDTO> getBookByPublishDate(LocalDate publishDate) {
        return Optional.empty();
    }

    @Override
    public Slice<BookDTO> getBooksPublishedBefore(LocalDate publishDate, Pageable pageable) {
        return null;
    }

    @Override
    public Slice<BookDTO> getBooksPublishedAfter(LocalDate publishDate, Pageable pageable) {
        return null;
    }

    @Override
    public Slice<BookDTO> getAllBooks(Pageable pageable) {
        return null;
    }

    @Override
    public Slice<BookDTO> getBooksByGenre(String genreName, Pageable pageable) {
        return null;
    }

    @Override
    public Slice<BookDTO> searchBooksFor(String searchQuery, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteBook(String bookTitle) {

    }
}

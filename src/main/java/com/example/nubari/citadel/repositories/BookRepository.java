package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Book;
import com.example.nubari.citadel.models.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Slice<Book> findBookByPublishDateAfter(LocalDate date, Pageable pageable);
    Slice<Book> findBookByPublishDateBefore(LocalDate date, Pageable pageable);
    Slice<Book> findBooksByTitleContaining(String title, Pageable pageable);
    Slice<Book> findBooksByGenre(Genre genre, Pageable pageable);
}

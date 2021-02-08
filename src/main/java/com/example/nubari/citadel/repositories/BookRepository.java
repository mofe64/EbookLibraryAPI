package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBookByPublishedDateAfter(LocalDateTime date);
    List<Book> findBookByPublishedDateBefore(LocalDateTime date);
}

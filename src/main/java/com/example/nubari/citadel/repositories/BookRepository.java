package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBookByPublishDateAfter(LocalDateTime date);
    List<Book> findBookByPublishDateBefore(LocalDateTime date);
    Slice<Book> findBooksByTitleContaining(String title, Pageable pageable);
}

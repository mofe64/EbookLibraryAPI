package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
}

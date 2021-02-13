package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
}

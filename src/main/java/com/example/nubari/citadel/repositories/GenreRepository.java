package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findGenreByName(String name);
}

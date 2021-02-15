package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}

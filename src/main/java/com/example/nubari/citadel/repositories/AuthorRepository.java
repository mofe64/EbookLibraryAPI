package com.example.nubari.citadel.repositories;

import com.example.nubari.citadel.models.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    Slice<Author> findAuthorByFirstnameStartingWith(String startingString, Pageable pageable);
    Slice<Author> findAuthorByFirstname(String firstname, Pageable pageable);
    Slice<Author> findAuthorByLastname(String lastname, Pageable pageable);

}

package com.example.nubari.citadel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Authors")
public class Author {
    @Id
    private String id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @DBRef
    private List<Book> books = new ArrayList<>();
}

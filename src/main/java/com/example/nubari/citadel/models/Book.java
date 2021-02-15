package com.example.nubari.citadel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    @NotBlank
    private String title;
    private String coverImage;
    private String summary;
    private String link;
    @NotNull
    @DBRef
    private Author author;
    private LocalDateTime publishDate;
}

package com.example.nubari.citadel.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    private String title;
    private String coverImage;
    private String summary;
    private String link;
    @DBRef
    private Author author;
    private LocalDateTime publishDate;
}

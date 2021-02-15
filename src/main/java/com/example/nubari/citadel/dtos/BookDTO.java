package com.example.nubari.citadel.dtos;

import com.example.nubari.citadel.models.Author;
import com.example.nubari.citadel.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String id;
    @NotBlank
    @NotNull
    @Min(value = 3, message = "Book Title must be at least 3 characters long")

    private String title;
    private String coverImage;
    private String summary;
    private String link;
    @NotNull(message = "A Book must have an author")
    private Author author;
    @NotBlank(message = "A Book must have a publish date")
    private LocalDate publishDate;
    @NotNull(message = "A book must have a genre")
    private Genre genre;
}

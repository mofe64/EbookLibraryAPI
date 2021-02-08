package com.example.nubari.citadel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    private String id;
    private String name;
    private String description;
}

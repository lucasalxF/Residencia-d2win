package com.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ModelIA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

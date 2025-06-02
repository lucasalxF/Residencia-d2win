package com.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String fileType;
    private String classification;
    private String result;
    private LocalDateTime uploadDate;
    private String status;

    @ManyToOne
    private Client client;

    @ManyToOne
    private ModelIA model;
}

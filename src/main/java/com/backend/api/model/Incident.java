package com.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorMessage;
    private LocalDateTime timestamp;
    private String status;

    @ManyToOne
    private Client client;

    @ManyToOne
    private ModelIA model;

    public void setStatus(String closed) {
    }
}

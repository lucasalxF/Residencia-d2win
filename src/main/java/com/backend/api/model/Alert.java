package com.backend.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // erro crítico, falha menor
    private String status; // ativo, resolvido
    private LocalDateTime createdAt;

    @ManyToOne
    private Incident incident;
}

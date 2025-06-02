package com.backend.api.controller;

import com.backend.api.model.Document;
import com.backend.api.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
@CrossOrigin(origins = "*")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // 🔎 Buscar todos os documentos
    @GetMapping
    public ResponseEntity<List<Document>> getAll() {
        List<Document> documents = documentService.findAll();
        return ResponseEntity.ok(documents);
    }

    // 🔍 Buscar documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Document> document = documentService.findById(id);
        if (document.isPresent()) {
            return ResponseEntity.ok(document.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Documento não encontrado com o ID: " + id);
        }
    }

    // 📤 Upload e processamento do documento
    @PostMapping("/upload")
    public ResponseEntity<?> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("classification") String classification
    ) {
        try {
            Document document = documentService.processDocument(file, classification);
            return ResponseEntity.status(HttpStatus.CREATED).body(document);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o documento: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado: " + e.getMessage());
        }
    }

    // 🗑️ Deletar documento
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Document> document = documentService.findById(id);
        if (document.isPresent()) {
            documentService.delete(id);
            return ResponseEntity.ok("Documento deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Documento não encontrado com o ID: " + id);
        }
    }
}

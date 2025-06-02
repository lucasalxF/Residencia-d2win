package com.backend.api.service;

import com.backend.api.model.Document;
import com.backend.api.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private Di2winService di2winService;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public void delete(Long id) {
        documentRepository.deleteById(id);
    }


    public Document processDocument(MultipartFile file, String classification) throws IOException {
        String result = di2winService.processDocument(file, classification);

        Document document = new Document();
        document.setFilename(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        document.setClassification(classification);
        document.setResult(result);
        document.setStatus("Processado");
        document.setUploadDate(LocalDateTime.now());

        return documentRepository.save(document);
    }
}

package com.backend.api.service;

import com.backend.api.model.ModelIA;
import com.backend.api.repository.ModelIARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelIAService {

    @Autowired
    private ModelIARepository modelIARepository;

    public List<ModelIA> findAll() {
        return modelIARepository.findAll();
    }

    public Optional<ModelIA> findById(Long id) {
        return modelIARepository.findById(id);
    }

    public ModelIA save(ModelIA modelIA) {
        return modelIARepository.save(modelIA);
    }

    public void delete(Long id) {
        modelIARepository.deleteById(id);
    }
}

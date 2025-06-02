package com.backend.api.controller;

import com.backend.api.model.ModelIA;
import com.backend.api.service.ModelIAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@CrossOrigin(origins = "*")
public class ModelIAController {

    @Autowired
    private ModelIAService modelIAService;

    @GetMapping
    public List<ModelIA> getAll() {
        return modelIAService.findAll();
    }

    @PostMapping
    public ModelIA create(@RequestBody ModelIA modelIA) {
        return modelIAService.save(modelIA);
    }

    @GetMapping("/{id}")
    public ModelIA getById(@PathVariable Long id) {
        return modelIAService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        modelIAService.delete(id);
    }
}

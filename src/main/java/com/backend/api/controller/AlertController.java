package com.backend.api.controller;

import com.backend.api.model.Alert;
import com.backend.api.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "*")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getAll() {
        return alertService.findAll();
    }

    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        alert.setCreatedAt(LocalDateTime.now());
        alert.setStatus("ativo");
        return alertService.save(alert);
    }

    @PatchMapping("/{id}/resolve")
    public Alert resolve(@PathVariable Long id) {
        Alert alert = alertService.findById(id).orElse(null);
        if (alert != null) {
            alert.setStatus("resolvido");
            return alertService.save(alert);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alertService.delete(id);
    }
}

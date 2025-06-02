package com.backend.api.service;

import com.backend.api.model.Alert;
import com.backend.api.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    public Optional<Alert> findById(Long id) {
        return alertRepository.findById(id);
    }

    public Alert save(Alert alert) {
        return alertRepository.save(alert);
    }

    public void delete(Long id) {
        alertRepository.deleteById(id);
    }
}

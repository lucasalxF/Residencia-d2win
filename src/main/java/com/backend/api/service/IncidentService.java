package com.backend.api.service;

import com.backend.api.model.Incident;
import com.backend.api.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    public Optional<Incident> findById(Long id) {
        return incidentRepository.findById(id);
    }

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    public void delete(Long id) {
        incidentRepository.deleteById(id);
    }
}

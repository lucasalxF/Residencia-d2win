package com.backend.api.controller;

import com.backend.api.model.Incident;
import com.backend.api.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/incidents")
@CrossOrigin(origins = "*")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAll() {
        return incidentService.findAll();
    }

    @PostMapping
    public Incident create(@RequestBody Incident incident) {
        incident.setTimestamp(LocalDateTime.now());
        incident.setStatus("open");
        return incidentService.save(incident);
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable Long id) {
        return incidentService.findById(id).orElse(null);
    }

    @PatchMapping("/{id}/close")
    public Incident closeIncident(@PathVariable Long id) {
        Incident incident = incidentService.findById(id).orElse(null);
        if (incident != null) {
            incident.setStatus("closed");
            return incidentService.save(incident);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        incidentService.delete(id);
    }
}

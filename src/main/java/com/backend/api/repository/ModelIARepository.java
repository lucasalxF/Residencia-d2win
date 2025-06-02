package com.backend.api.repository;

import com.backend.api.model.ModelIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelIARepository extends JpaRepository<ModelIA, Long> {
}

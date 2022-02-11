package com.crm.clinicCrm.semnatura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemnaturaRepository extends JpaRepository<SemnaturaModel, UUID> {
    SemnaturaModel findByChestionarEvalGenId(UUID chestionarEvalGenId);
    boolean existsByChestionarEvalGenId(UUID chestionarEvalGenId);
}

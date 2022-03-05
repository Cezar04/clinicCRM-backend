package com.crm.clinicCrm.semnatura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemnaturaRepository extends JpaRepository<SemnaturaModel, UUID> {
    SemnaturaModel findByChestionarId(UUID chestionarEvalGenId);
    SemnaturaModel findByClientIdAndNumeChestionar(UUID clinetId, String numeChestionar);
    boolean existsByChestionarId(UUID chestionarEvalGenId);
    boolean existsByNumeChestionarAndAndClientId(String numeChestionar, UUID clientid);
}

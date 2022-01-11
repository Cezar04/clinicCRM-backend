package com.crm.clinicCrm.chestionarEvalGenerala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChestionarEvalGenRepository extends JpaRepository<ChestionarEvalGenModal, UUID> {
    Optional<ChestionarEvalGenModal>findById(UUID chestionarEvalGenId);
//    TODO add existsByClientId andFindByClientId
}

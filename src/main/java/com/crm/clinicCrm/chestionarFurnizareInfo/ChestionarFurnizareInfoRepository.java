package com.crm.clinicCrm.chestionarFurnizareInfo;

import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChestionarFurnizareInfoRepository extends JpaRepository<ChestionarFurnizareInfoModel, UUID> {
    Optional<ChestionarFurnizareInfoModel> findById(UUID chestionarId);
    ChestionarFurnizareInfoModel findByClientId(UUID clientId);
    boolean existsByClientId(UUID clientId);


}

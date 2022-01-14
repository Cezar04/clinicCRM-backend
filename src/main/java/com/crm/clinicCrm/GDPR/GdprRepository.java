package com.crm.clinicCrm.GDPR;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GdprRepository extends JpaRepository<GdprModel, UUID> {
    GdprModel findByClientId(UUID clientId);

}

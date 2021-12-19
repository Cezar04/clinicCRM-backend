package com.crm.clinicCrm.medicalRecord;

import com.crm.clinicCrm.client.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecordRepository extends JpaRepository<RecordModel, UUID> {

    Optional<RecordModel> findById(UUID recordId);
    RecordModel findByClient(ClientModel client);
    boolean existsByClient(ClientModel client);
}

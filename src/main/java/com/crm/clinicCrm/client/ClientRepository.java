package com.crm.clinicCrm.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    Optional<ClientModel> findById(UUID clientId);
    Optional<ClientModel> findByEmailAndFirstName(String email, String firstName);
    Boolean existsByEmail (String email);
    
}

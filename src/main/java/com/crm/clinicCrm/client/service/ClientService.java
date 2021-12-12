package com.crm.clinicCrm.client.service;

import com.crm.clinicCrm.client.ClientDAO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<ClientDAO> findAll();
    ResponseEntity<?>addClient(ClientDAO clientDAO);
    ClientDAO findByClientId(UUID clientId);
    ResponseEntity<?> updateClient(ClientDAO clientDAO, UUID clientId);
    ResponseEntity<?> deleteClient(UUID clientId);

//    TODO make get by email and by name methods, implement update and delete
}

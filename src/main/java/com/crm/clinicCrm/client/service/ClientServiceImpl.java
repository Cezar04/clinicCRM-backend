package com.crm.clinicCrm.client.service;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ServiceHelper serviceHelper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<ClientDAO> findAll() {
        List<ClientDAO> allClients = new ArrayList<>();
        Iterable<ClientModel> clients = clientRepository.findAll();
        clients.forEach(clientModel -> allClients.add(serviceHelper.convertToClientDAO(clientModel)));

        return allClients;
    }

    @Override
    public ResponseEntity<?> addClient(ClientDAO clientDAO) {
        ClientModel client = serviceHelper.convertToClientEntity(clientDAO);
        client.setCreateDateTime(new Date());
        clientRepository.save(client);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @Override
    public ClientDAO findByClientId(UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        return clientModelOptional.map(serviceHelper:: convertToClientDAO).orElse(null);
    }

    @Override
    public Boolean existsEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

    @Override
    public ResponseEntity<?> updateClient(ClientDAO clientDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        ClientModel unmanagedClientEntity = serviceHelper.convertToClientEntity(clientDAO);

        if (clientModelOptional.isPresent()){
            ClientModel managedClientEntity = clientModelOptional.get();

            managedClientEntity.setFirstName(unmanagedClientEntity.getFirstName());
            managedClientEntity.setLastName(unmanagedClientEntity.getLastName());
            managedClientEntity.setEmail(unmanagedClientEntity.getEmail());
            managedClientEntity.setPhoneNumber(unmanagedClientEntity.getPhoneNumber());
            managedClientEntity.setSex(unmanagedClientEntity.getSex());
            managedClientEntity.setAge(unmanagedClientEntity.getAge());
            managedClientEntity.setCNP(unmanagedClientEntity.getCNP());
            managedClientEntity.setAddress(unmanagedClientEntity.getAddress());
            managedClientEntity.setOccupation(unmanagedClientEntity.getOccupation());
            managedClientEntity.setGDPR(unmanagedClientEntity.isGDPR());

            clientRepository.save(managedClientEntity);

            return ResponseEntity.status(HttpStatus.OK).body(managedClientEntity +" Client Updated");
        }else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("client "+ clientId+" not found");
        }


        return  null;
    }

    @Override
    public ResponseEntity<?> deleteClient(UUID clientId) {
        Optional<ClientModel> managedClientEntity = clientRepository.findById(clientId);

        if (managedClientEntity.isPresent()){
            ClientModel clientModel = managedClientEntity.get();
            clientRepository.delete(clientModel);
            return  new ResponseEntity<>(clientModel, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("no client found to delete!",HttpStatus.BAD_REQUEST);
        }
    }
}

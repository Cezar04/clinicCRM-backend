package com.crm.clinicCrm.GDPR.service;


import com.crm.clinicCrm.GDPR.GdprDAO;
import com.crm.clinicCrm.GDPR.GdprModel;
import com.crm.clinicCrm.GDPR.GdprRepository;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class GdprServiceImpl implements GdprService{

    private GdprRepository gdprRepository;
    private ClientRepository clientRepository;

    @Autowired
    public GdprServiceImpl(GdprRepository gdprRepository, ClientRepository clientRepository) {
        this.gdprRepository = gdprRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<?> addGdpr(GdprDAO gdprDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);

        if (clientModelOptional.isPresent()){
            GdprModel gdpr = new GdprModel();
            gdpr.setGdpr(gdprDAO.isGdpr());
            gdpr.setClient(clientModelOptional.get());
            gdprRepository.save(gdpr);

            return new ResponseEntity<>(gdpr, HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }
    }

    @Override
    public GdprModel findByClientId(UUID clientId) {
        Optional<ClientModel> clientModelOptional =clientRepository.findById(clientId);

        if (clientModelOptional.isPresent()){
            return gdprRepository.findByClientId(clientId);
        }else{
            return null;
        }
    }
}

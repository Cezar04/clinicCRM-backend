package com.crm.clinicCrm.chestionarEvalGenerala.service;

import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenDAO;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenModal;
import com.crm.clinicCrm.chestionarEvalGenerala.ChestionarEvalGenRepository;
import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ChestionarEvalGenServiceImpl implements ChestionarEvalGenService{
    private ChestionarEvalGenRepository chestionarEvalGenRepository;
    private ClientRepository clientRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public ChestionarEvalGenServiceImpl(ChestionarEvalGenRepository chestionarEvalGenRepository, ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.chestionarEvalGenRepository = chestionarEvalGenRepository;
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<ChestionarEvalGenModal> findAll() {
        return chestionarEvalGenRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addChestionrEvalGenService(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);

        if (clientModelOptional.isPresent()){
            ChestionarEvalGenModal chestionar = serviceHelper.convertToChestionarEvalGenEntity(chestionarEvalGenDAO);
            chestionar.setCreateDateTime(new Date());
            chestionar.setClient(clientModelOptional.get());
            chestionarEvalGenRepository.save(chestionar);

            return new ResponseEntity<>(chestionar, HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }

    }

    @Override
    public ChestionarEvalGenModal findChestionarEvalGenByClientId(UUID clientId) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateChestionarEvalGen(ChestionarEvalGenDAO chestionarEvalGenDAO, UUID chestionarEvalGenId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteChestionarEvalGen(UUID chestionarEvalGenId) {
        return null;
    }

    @Override
    public boolean existChestionarEvalGen(UUID clientId) {
        return false;
    }
}

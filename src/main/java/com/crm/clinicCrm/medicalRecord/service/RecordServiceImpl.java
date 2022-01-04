package com.crm.clinicCrm.medicalRecord.service;

import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import com.crm.clinicCrm.medicalRecord.RecordDAO;
import com.crm.clinicCrm.medicalRecord.RecordModel;
import com.crm.clinicCrm.medicalRecord.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class RecordServiceImpl implements RecordService{
    private RecordRepository recordRepository;
    private ClientRepository clientRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.recordRepository = recordRepository;
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<RecordModel> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addRecord(RecordDAO recordDAO, UUID clientID) {
        Optional<ClientModel > clientModelOptional = clientRepository.findById(clientID);

        if(clientModelOptional.isPresent()){
           RecordModel record = new RecordModel();
           record.setComment(recordDAO.getComment());
           record.setProcedure(recordDAO.getProcedure());
           record.setConfirmed(recordDAO.isConfirmed());
           record.setClient(clientModelOptional.get());
           recordRepository.save(record);

            return new ResponseEntity<>(record, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }

    }
    @Override
    public RecordModel findRecordByClientId(UUID clientId) {
        Optional<ClientModel> clientModelOptional =clientRepository.findById(clientId);

        if(clientModelOptional.isPresent()){
            return recordRepository.findByClientId(clientId);

        }else{
            return null;
        }
    }

    @Override
    public ResponseEntity<?> updateRecord(RecordDAO recordDAO, UUID recordId) {
        Optional<RecordModel> recordModelOptional = recordRepository.findById(recordId);
        RecordModel unmanagedRecordEntity = serviceHelper.convertToRecordEntity(recordDAO);

        if (recordModelOptional.isPresent()){
            RecordModel managedRecordEntity = recordModelOptional.get();
            managedRecordEntity.setProcedure(unmanagedRecordEntity.getProcedure());
            managedRecordEntity.setComment(unmanagedRecordEntity.getComment());
            recordRepository.save(managedRecordEntity);

            return ResponseEntity.status(HttpStatus.OK).body(managedRecordEntity +" Record updated");
        }else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("record "+recordId+" not found");
        }

        return null;
    }

    @Override
    public ResponseEntity<?> deleteRecord(UUID recordId) {
        Optional<RecordModel> recordModelOptional = recordRepository.findById(recordId);

        if (recordModelOptional.isPresent()){
            RecordModel recordModel = recordModelOptional.get();
            recordRepository.delete(recordModel);

            return new ResponseEntity<>(recordModel, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("no record found to delete!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public boolean existsRecord(UUID clientId) {
        return recordRepository.existsByClientId(clientId);
    }
}

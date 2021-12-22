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
    public List<RecordDAO> findAll() {
        List<RecordDAO> allRecords = new ArrayList<>();
        Iterable<RecordModel> records = recordRepository.findAll();
        records.forEach(recordModel -> allRecords.add(serviceHelper.convertToRecordDAO(recordModel)));
        return allRecords;
    }

    @Override
    public ResponseEntity<?> addRecord(RecordDAO recordDAO, UUID clientID) {
        Optional<ClientModel > clientModelOptional = clientRepository.findById(clientID);

        if(clientModelOptional.isPresent()){
           RecordModel record = new RecordModel();
           record.setComment(recordDAO.getComment());
           record.setProcedure(recordDAO.getProcedure());
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
    public ResponseEntity<?> updateRecord(RecordDAO recordDAO, UUID recordId, UUID clientId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteRecord(UUID recordId) {
        return null;
    }
}

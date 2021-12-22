package com.crm.clinicCrm.medicalRecord.service;

import com.crm.clinicCrm.medicalRecord.RecordDAO;
import com.crm.clinicCrm.medicalRecord.RecordModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RecordService {
    List<RecordModel> findAll();
    ResponseEntity<?> addRecord(RecordDAO recordDAO, UUID clientID);
    RecordModel findRecordByClientId(UUID clientId);
//    TODO add findRecordBy DoctorID
    ResponseEntity<?> updateRecord(RecordDAO recordDAO, UUID recordId, UUID clientId);
    ResponseEntity<?> deleteRecord(UUID recordId);

}

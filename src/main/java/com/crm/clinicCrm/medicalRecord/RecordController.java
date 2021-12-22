package com.crm.clinicCrm.medicalRecord;

import com.crm.clinicCrm.medicalRecord.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/medical-record")
public class RecordController {

    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/all-records")
    public List<RecordDAO> getAllRecords(){
        return recordService.findAll();
    }


    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> addMedicalRecord(@RequestBody RecordDAO recordDAO,@PathVariable UUID clientId){
        return recordService.addRecord(recordDAO,clientId);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> getRecordByClient(@PathVariable UUID clientId){
        return  new ResponseEntity<>(recordService.findRecordByClientId(clientId), HttpStatus.OK);
    }
}

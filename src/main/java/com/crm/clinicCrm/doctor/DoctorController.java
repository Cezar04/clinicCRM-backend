package com.crm.clinicCrm.doctor;


import com.crm.clinicCrm.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all-doctors")
    public List<DoctorDAO> getAllDoctors(){
        return doctorService.findAll();
    }

    @PostMapping("/add-doctor")
    private ResponseEntity<?> addDoctor(@RequestBody DoctorDAO doctorDAO){
        return doctorService.addDoctor(doctorDAO);
    }

    @GetMapping("/{doctorId}")
    public DoctorDAO getDoctor(@PathVariable UUID doctorId){
        return doctorService.findByDoctorId(doctorId);
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable UUID doctorId) {
        return doctorService.deleteDoctor(doctorId);}

    @PutMapping("/edit/{doctorId}")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorDAO doctorDAO, @PathVariable UUID doctorId) {
        return doctorService.updateDoctor(doctorDAO, doctorId);
    }

}

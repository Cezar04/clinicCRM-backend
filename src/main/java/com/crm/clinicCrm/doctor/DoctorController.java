package com.crm.clinicCrm.doctor;


import com.crm.clinicCrm.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}

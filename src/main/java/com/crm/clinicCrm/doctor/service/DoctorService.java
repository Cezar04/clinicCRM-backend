package com.crm.clinicCrm.doctor.service;

import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    List<DoctorDAO> findAll();
    ResponseEntity<?>addDoctor(DoctorDAO doctorDAO);
    DoctorDAO findByDoctorId(UUID doctorId);
    ResponseEntity<?> updateDoctor(DoctorDAO doctorDAO, UUID doctorId);
    ResponseEntity<?> deleteDoctor(UUID doctorId);


}

package com.crm.clinicCrm.doctor.service;

import com.crm.clinicCrm.doctor.DoctorDAO;
import com.crm.clinicCrm.doctor.DoctorModel;
import com.crm.clinicCrm.doctor.DoctorRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{
    private DoctorRepository doctorRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, ServiceHelper serviceHelper) {
        this.doctorRepository = doctorRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<DoctorDAO> findAll() {
        List<DoctorDAO> allDoctors = new ArrayList<>();
        Iterable<DoctorModel> doctors = doctorRepository.findAll();
        doctors.forEach(doctorModel -> allDoctors.add(serviceHelper.convertToDoctorDAO(doctorModel)));
        return allDoctors;
    }

    @Override
    public ResponseEntity<?> addDoctor(DoctorDAO doctorDAO) {
        DoctorModel doctor = serviceHelper.convertToDoctorEntity(doctorDAO);
//        add client?
        doctorRepository.save(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @Override
    public DoctorDAO findByDoctorId(UUID doctorId) {
        Optional<DoctorModel> doctorModelOptional = doctorRepository.findById(doctorId);
        return doctorModelOptional.map(serviceHelper::convertToDoctorDAO).orElse(null);
    }

    @Override
    public ResponseEntity<?> updateDoctor(DoctorDAO doctorDAO, UUID doctorId) {
        Optional<DoctorModel> doctorModelOptional = doctorRepository.findById(doctorId);
        DoctorModel unmanagedDoctorEntity = serviceHelper.convertToDoctorEntity(doctorDAO);

        if (doctorModelOptional.isPresent()) {
            DoctorModel managedDoctorEntity = doctorModelOptional.get();
            managedDoctorEntity.setName(unmanagedDoctorEntity.getName());
            managedDoctorEntity.setDomain(unmanagedDoctorEntity.getDomain());
            managedDoctorEntity.setEmail(unmanagedDoctorEntity.getEmail());
            managedDoctorEntity.setPhoneNumber(unmanagedDoctorEntity.getPhoneNumber());

            doctorRepository.save(managedDoctorEntity);

            return ResponseEntity.status(HttpStatus.OK).body(managedDoctorEntity + "Doctor Updated");
        }else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("doctor" + doctorId + "not found");
        }

        return null;
    }

    @Override
    public ResponseEntity<?> deleteDoctor(UUID doctorId) {
        Optional<DoctorModel> managedDoctorEntity = doctorRepository.findById(doctorId);

        if (managedDoctorEntity.isPresent()) {
            DoctorModel doctorModel = managedDoctorEntity.get();
            doctorRepository.delete(doctorModel);
            return new ResponseEntity<>(doctorModel, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No doctor found to delete!", HttpStatus.BAD_REQUEST);
        }
    }

}

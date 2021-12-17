package com.crm.clinicCrm.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
    Optional<DoctorModel> findById(UUID doctorId);
}

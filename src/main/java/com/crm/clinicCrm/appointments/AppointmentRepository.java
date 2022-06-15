package com.crm.clinicCrm.appointments;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
    Optional<AppointmentModel> findById(UUID appointmentId);

    @Query("SELECT a FROM AppointmentModel a WHERE a.doctorName = :doctorName")
    List<AppointmentModel> getAppointmentByDoctorName(String doctorName);

    List<AppointmentModel> findByClientFirstNameAndClientLastName(String clientFirstName, String clientLastName);

}

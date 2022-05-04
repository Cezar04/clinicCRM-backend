package com.crm.clinicCrm.appointments.service;

import com.crm.clinicCrm.appointments.AppointmentDAO;
import com.crm.clinicCrm.appointments.ClientNameDao;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    List<AppointmentDAO> getAllAppointments();
    ResponseEntity<?> createNewAppointment(AppointmentDAO appointmentDAO);
    AppointmentDAO getAppointmentById(UUID appointmentId);
    AppointmentDAO getAppointmentByDoctorName(String doctorName);
    AppointmentDAO getAppointmentByClientName(ClientNameDao clientNameDao);
    ResponseEntity<?>  updateAppointment(AppointmentDAO appointmentDAO, UUID appointmentId);
    ResponseEntity<?> deleteAppointmentById(UUID appointmentId);



}

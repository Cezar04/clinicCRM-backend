package com.crm.clinicCrm.appointments.service;

import com.crm.clinicCrm.appointments.AppointmentDAO;
import com.crm.clinicCrm.appointments.AppointmentModel;
import com.crm.clinicCrm.appointments.AppointmentRepository;
import com.crm.clinicCrm.appointments.ClientNameDao;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private  AppointmentRepository appointmentRepository;
    private  ServiceHelper serviceHelper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ServiceHelper serviceHelper) {
        this.appointmentRepository = appointmentRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<AppointmentDAO> getAllAppointments() {

        List<AppointmentDAO> allAppointments = new ArrayList<>();
        Iterable<AppointmentModel> appointments = appointmentRepository.findAll();
        appointments.forEach(appointmentModel -> allAppointments.add(serviceHelper.convertToAppointmentDAO(appointmentModel)));

        return allAppointments;
    }

    @Override
    public ResponseEntity<?> createNewAppointment(AppointmentDAO appointmentDAO) {
        AppointmentModel appointment = serviceHelper.convertToAppointmentEntity(appointmentDAO);
        appointment.setDoctorId(appointmentDAO.getDoctorId());
        appointmentRepository.save(appointment);

        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @Override
    public AppointmentDAO getAppointmentById(UUID appointmentId) {
        Optional<AppointmentModel> appointmentModelOptional = appointmentRepository.findById(appointmentId);
        return appointmentModelOptional.map(serviceHelper::convertToAppointmentDAO).orElse(null);
    }

    @Override
    public AppointmentDAO getAppointmentByDoctorName(String doctorName) {
        return serviceHelper.convertToAppointmentDAO(appointmentRepository.getAppointmentByDoctorName(doctorName).get(0));
    }

    @Override
    public AppointmentDAO getAppointmentByClientName(ClientNameDao clientName) {
        Optional<AppointmentModel> appointmentModelOptional = appointmentRepository.findByClientName(clientName.getFirstName(),clientName.getLastName());
        return appointmentModelOptional.map(serviceHelper::convertToAppointmentDAO).orElse(null);
    }

    @Override
    public ResponseEntity<?> updateAppointment(AppointmentDAO appointmentDAO, UUID appointmentId) {
        Optional<AppointmentModel> appointmentModelOptional = appointmentRepository.findById(appointmentId);
        AppointmentModel unmanagedAppointmentEntity = serviceHelper.convertToAppointmentEntity(appointmentDAO);

        if (appointmentModelOptional.isPresent()) {
            AppointmentModel managedAppointmentEntity = appointmentModelOptional.get();
//            managedAppointmentEntity.setDoctorId(unmanagedAppointmentEntity.getDoctorId());
            managedAppointmentEntity.setProcedure(unmanagedAppointmentEntity.getProcedure());

            appointmentRepository.save(managedAppointmentEntity);

            return ResponseEntity.status(HttpStatus.OK).body(managedAppointmentEntity + "Appointment Updated");
        }else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("appointment" + appointmentId + "not found");
        }

        return null;
    }

    @Override
    public ResponseEntity<?> deleteAppointmentById(UUID appointmentId) {
        Optional<AppointmentModel> managedAppointmentEntity = appointmentRepository.findById(appointmentId);

        if (managedAppointmentEntity.isPresent()) {
            AppointmentModel appointmentModel = managedAppointmentEntity.get();
            appointmentRepository.delete(appointmentModel);
            return new ResponseEntity<>(appointmentModel, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No appointment found to delete!", HttpStatus.BAD_REQUEST);
        }
    }
}

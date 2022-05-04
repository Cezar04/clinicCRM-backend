package com.crm.clinicCrm.appointments;

import com.crm.clinicCrm.appointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all-appointments")
    public List<AppointmentDAO> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/create-appointment")
    private ResponseEntity<?> createNewAppointment(@RequestBody AppointmentDAO appointmentDAO){
        return appointmentService.createNewAppointment(appointmentDAO);
    }

    @GetMapping("/{appointmentId}")
    public AppointmentDAO getAppointmentById(@PathVariable UUID appointmentId){
        return appointmentService.getAppointmentById(appointmentId);
    }


    @GetMapping("/doctors/{doctorName}")
    public AppointmentDAO getAppointmentByDoctorName(@PathVariable String doctorName) {
        return appointmentService.getAppointmentByDoctorName(doctorName);
    }

    @GetMapping("/clients/{firstName}/{lastName}")
    public List<AppointmentDAO> getAppointmentByClientFirstNameAndLastName(@PathVariable String firstName, String lastName) {
        return appointmentService.getAppointmentByClientName(firstName, lastName);
    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable UUID appointmentId) {
        return appointmentService.deleteAppointmentById(appointmentId);}

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDAO appointmentDAO, @PathVariable UUID appointmentId) {
        return appointmentService.updateAppointment(appointmentDAO, appointmentId);
    }

}


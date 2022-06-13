package com.crm.clinicCrm.appointments;


import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentModel {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "id")
    private UUID id;

    private UUID doctorId;
    private String doctorName;

    private String clientFirstName;
    private String clientLastName;
    private String procedure;

    @DateTimeFormat()
    private LocalDateTime startDate;

    @DateTimeFormat()
    private LocalDateTime endDate;

    public void setDoctorId(UUID doctorId) {
    }

}
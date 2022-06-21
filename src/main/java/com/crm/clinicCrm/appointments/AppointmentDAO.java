package com.crm.clinicCrm.appointments;


import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDAO {
    private UUID id;

    private UUID doctorId;

    private String doctorName;
    private String clientFirstName;
    private String clientLastName;
    private LocalDateTime start;
    private LocalDateTime end;
    private String procedure;
    private String comments;

}

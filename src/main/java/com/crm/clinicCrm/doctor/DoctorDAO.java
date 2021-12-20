package com.crm.clinicCrm.doctor;

import lombok.*;

import javax.validation.constraints.Email;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorDAO {
    private UUID id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
}

package com.crm.clinicCrm.doctor;

import lombok.*;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorDAO {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
}

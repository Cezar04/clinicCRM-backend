package com.crm.clinicCrm.client;

import lombok.*;

import javax.validation.constraints.Email;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDAO {
    private UUID id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    private String sex;
    private int age;
    private String CNP;
    private String address;
    private String occupation;
    private String birthDate;


}

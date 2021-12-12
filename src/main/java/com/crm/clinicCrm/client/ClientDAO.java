package com.crm.clinicCrm.client;

import lombok.*;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDAO {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    private boolean isGDPR;
    private boolean isCONSENT;
}

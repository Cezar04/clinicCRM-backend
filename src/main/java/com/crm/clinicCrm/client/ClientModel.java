package com.crm.clinicCrm.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "client")
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
//    field pentru protectia datelor
    private boolean isGDPR;
//    field pentru consimtamantul medical
    private boolean isCONSENT;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;
}

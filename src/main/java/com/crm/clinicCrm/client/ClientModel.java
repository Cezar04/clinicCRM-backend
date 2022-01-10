package com.crm.clinicCrm.client;


import com.crm.clinicCrm.medicalRecord.RecordModel;
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
    @Column(name = "client_id")
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String sex;
    private int age;
    private String CNP;
    private String address;
    private String occupation;
//    field pentru protectia datelor
    private boolean isGDPR;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;
}

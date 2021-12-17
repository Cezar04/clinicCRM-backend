package com.crm.clinicCrm.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorModel {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "doctor")
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;






}

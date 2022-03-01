package com.crm.clinicCrm.semnatura;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "semnatura")
public class SemnaturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "semnatura_id")
    private UUID id;

    @Column
    private String numeSemnatura;
    @Lob
    private String data;
    private UUID chestionarId;
    private UUID clientId;


    private LocalDate createDateTime;

}

package com.crm.clinicCrm.medicalRecord;


import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "record")
public class RecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "record_id")
    private UUID id;

    @ElementCollection
    private List<String>  procedure;
    @ElementCollection
    private List<String> comment;

    private boolean isConfirmed;

//TODO Bug nu merge sa updatezi confirmul
//    TODO adauga data la care a fost facut fisa, si data la care a fost modificata
//    TODO adauga fielduri cu alte date despre pacient


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;
}

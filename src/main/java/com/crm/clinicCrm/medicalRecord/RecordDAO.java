package com.crm.clinicCrm.medicalRecord;


import com.crm.clinicCrm.client.ClientModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecordDAO {

    private String procedure;
    private String comment;

    private ClientModel client;
}

package com.crm.clinicCrm.medicalRecord;


import com.crm.clinicCrm.client.ClientModel;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecordDAO {
    private UUID id;
    private List<String> procedure;
    private List<String> comment;
    private boolean isConfirmed;

}

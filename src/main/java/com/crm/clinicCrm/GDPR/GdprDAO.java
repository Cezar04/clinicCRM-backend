package com.crm.clinicCrm.GDPR;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GdprDAO {
    private UUID id;
    private boolean isGdpr;

}

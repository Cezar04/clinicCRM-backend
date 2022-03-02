package com.crm.clinicCrm.chestionarFurnizareInfo;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChestionarFurnizareInfoDAO {
    private UUID id;

    private boolean supozitiiDiagnostic;
    private boolean prognostic;
    private boolean naturaSiScopulActuluiMedical;
    private boolean interventiileSiStrategie;
    private boolean beneficiileSiConsecintele;
    private boolean riscurilePotentiale;
    private boolean alternativeViabile;
    private boolean riscurileNeefectuarii;
    private boolean rescurileNerespectaiiRecomandarilor;

    private boolean informatiiDespreServiciileMedicale;
    private boolean informatiiDespreIdendtitateaPersonalului;
    private boolean informatiiDespreReguli;
    private boolean dreptulLaADouaOpinie;

    private boolean situatiiNeprevazute;
    private boolean potRefuzaProcesulEducational;

    private String mediaInformatiilor;

    private String numeSiPrenume;
    private String mentiuni;

    private LocalDate createdDateTime;
}

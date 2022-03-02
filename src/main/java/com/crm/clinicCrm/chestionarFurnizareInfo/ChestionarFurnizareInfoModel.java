package com.crm.clinicCrm.chestionarFurnizareInfo;

import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "furnizareInfo")
public class ChestionarFurnizareInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "furnizareInfo_id")
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;
}

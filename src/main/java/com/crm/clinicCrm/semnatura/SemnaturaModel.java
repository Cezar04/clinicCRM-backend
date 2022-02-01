package com.crm.clinicCrm.semnatura;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
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
    private byte[] data;
    private UUID chestionarEvalGenId;
    private UUID clientId;

}

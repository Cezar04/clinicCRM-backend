package com.crm.clinicCrm.GDPR;

import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GdprModel {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "gdpr_id")
    private UUID id;

    private boolean isGdpr;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;
}

package com.crm.clinicCrm.comments;

import com.crm.clinicCrm.client.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "comments")
public class CommentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "comments_id")
    private UUID id;

    private String comment;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientModel client;
}

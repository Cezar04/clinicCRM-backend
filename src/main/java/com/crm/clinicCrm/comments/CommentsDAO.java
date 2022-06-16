package com.crm.clinicCrm.comments;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentsDAO {
    private UUID id;
    private String comment;
}

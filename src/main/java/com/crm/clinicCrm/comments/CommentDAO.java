package com.crm.clinicCrm.comments;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDAO {

    private UUID id;
    private String content;
}

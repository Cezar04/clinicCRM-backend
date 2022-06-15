package com.crm.clinicCrm.comments.serivices;

import com.crm.clinicCrm.comments.CommentsDAO;
import com.crm.clinicCrm.comments.CommentsModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CommentsService {
    List<CommentsModel>findAll();
    List<CommentsModel>findAllByClientId(UUID clientId);
    ResponseEntity<?> addComment(CommentsDAO commentsDAO, UUID clientId);
    ResponseEntity<?> deleteComment(UUID commentId);
}

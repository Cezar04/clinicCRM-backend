package com.crm.clinicCrm.comments.service;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.comments.CommentDAO;
import com.crm.clinicCrm.comments.CommentModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentService {
    
    List<CommentModel> findByClientID(UUID clientId);

    Optional<CommentModel> findById(Long id);

    CommentModel save(CommentModel commentRequest);

    void deleteById(long id);

    void deleteByClientId(UUID clientId);
}

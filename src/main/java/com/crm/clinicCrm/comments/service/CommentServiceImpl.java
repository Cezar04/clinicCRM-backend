package com.crm.clinicCrm.comments.service;

import com.crm.clinicCrm.comments.CommentModel;
import com.crm.clinicCrm.comments.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<CommentModel> findByClientID(UUID clientId) {
        return commentRepository.findByClientID(clientId);
    }

    @Override
    public Optional<CommentModel> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public CommentModel save(CommentModel commentRequest) {
        return commentRepository.save(commentRequest);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteByClientId(UUID clientId) {
        commentRepository.deleteByClientId(clientId);
    }
}

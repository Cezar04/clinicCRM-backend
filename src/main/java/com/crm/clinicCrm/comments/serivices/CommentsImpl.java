package com.crm.clinicCrm.comments.serivices;

import com.crm.clinicCrm.client.ClientModel;
import com.crm.clinicCrm.client.ClientRepository;
import com.crm.clinicCrm.comments.CommentsDAO;
import com.crm.clinicCrm.comments.CommentsModel;
import com.crm.clinicCrm.comments.CommentsRepository;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CommentsImpl implements CommentsService{

    private CommentsRepository commentsRepository;
    private ClientRepository clientRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public CommentsImpl(CommentsRepository commentsRepository, ClientRepository clientRepository, ServiceHelper serviceHelper) {
        this.commentsRepository = commentsRepository;
        this.clientRepository = clientRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<CommentsModel> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public List<CommentsModel> findAllByClientId(UUID clientId) {
        return commentsRepository.findByClientId(clientId);
    }

    @Override
    public ResponseEntity<?> addComment(CommentsDAO commentsDAO, UUID clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if( clientModelOptional.isPresent()){
            CommentsModel comments = serviceHelper.convertToCommentEntity(commentsDAO);
            comments.setClient(clientModelOptional.get());

            commentsRepository.save(comments);

            return new ResponseEntity<>(comments, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("add client first");
        }

    }

    @Override
    public ResponseEntity<?> deleteComment(UUID commentId) {
        return null;
    }
}

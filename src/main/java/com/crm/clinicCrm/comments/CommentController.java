package com.crm.clinicCrm.comments;

import com.crm.clinicCrm.client.ClientDAO;
import com.crm.clinicCrm.client.service.ClientService;
import com.crm.clinicCrm.comments.service.CommentService;
import com.crm.clinicCrm.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    ClientService clientService;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    ServiceHelper serviceHelper;

    @GetMapping("/clients/{clientId}/comments")
    public ResponseEntity<List<CommentModel>> getAllCommentsByClientId(@PathVariable(value = "clientId") UUID clientId) {

        List<CommentModel> comments = commentService.findByClientID(clientId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentModel> getCommentById(@PathVariable(value = "id") Long id) {

        Optional<CommentModel> comment = commentService.findById(id);
        return comment.map(commentModel -> new ResponseEntity<>(commentModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/clients/{clientId}/comments")
    public ResponseEntity<CommentModel> createComment(@PathVariable(value = "clientId") UUID clientId,
                                                      @RequestBody CommentModel commentRequest) {
        ClientDAO client = clientService.findByClientId(clientId);
        commentRequest.setClientModel(serviceHelper.convertToClientEntity(client));
        commentService.save(commentRequest);

        return new ResponseEntity<>(commentRequest, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentModel> updateComment(@PathVariable("id") long id, @RequestBody CommentModel commentRequest) {
        Optional<CommentModel> comment = commentService.findById(id);
        if (comment.isPresent()) {

            comment.get().setContent(commentRequest.getContent());
            return new ResponseEntity<>(commentService.save(comment.get()), HttpStatus.OK);

        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/clients/{clientId}/comments")
    public ResponseEntity<List<CommentModel>> deleteAllCommentsOfClient(@PathVariable(value = "clientId") UUID clientId) {

        commentService.deleteByClientId(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

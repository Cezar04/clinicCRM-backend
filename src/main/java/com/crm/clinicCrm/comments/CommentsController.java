package com.crm.clinicCrm.comments;

import com.crm.clinicCrm.comments.serivices.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/add/{clientId}")
    private ResponseEntity<?> addComment(@RequestBody CommentsDAO commentsDAO, @PathVariable UUID clientId){
        return commentsService.addComment(commentsDAO,clientId);
    }
}

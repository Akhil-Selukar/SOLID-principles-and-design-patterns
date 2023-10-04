package com.solid.principles.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solid.principles.entity.Comment;
import com.solid.principles.repository.CommentRepository;

public class CommentController {
    private CommentRepository commentRepository = new CommentRepository();

    public String addNewComment(String payloadJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Comment comment = mapper.readValue(payloadJson, Comment.class);

        if(!validateComment(comment)) {
            return "FAILURE";
        }

        commentRepository.save(comment);

        return "SUCCESS";
    }

    //Validates the user object
    private boolean validateComment(Comment comment) {
        if(!isPresent(comment.getMessage())) {
            return false;
        }
        if(comment.getAuthor() == null || comment.getAuthor().trim().length() == 0) {
            return false;
        }
        return true;
    }

    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }
}

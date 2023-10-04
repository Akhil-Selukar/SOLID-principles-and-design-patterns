package com.solid.principles.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solid.principles.entity.Comment;
import com.solid.principles.repository.CommentRepository;
import com.solid.principles.util.PayloadValidator;

public class CommentService {
    private final CommentRepository commentRepository = new CommentRepository();
    private final PayloadValidator payloadValidator = new PayloadValidator();

    public String addNewComment(String payloadJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Comment comment = mapper.readValue(payloadJson, Comment.class);

        if(!payloadValidator.validateComment(comment)) {
            return "FAILURE";
        }

        commentRepository.save(comment);

        return "SUCCESS";
    }
}

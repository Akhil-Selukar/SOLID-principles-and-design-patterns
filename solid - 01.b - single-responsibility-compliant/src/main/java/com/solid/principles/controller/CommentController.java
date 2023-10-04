package com.solid.principles.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.solid.principles.service.CommentService;

public class CommentController {

    private CommentService commentService = new CommentService();

    public String addNewComment(String payloadJson) throws JsonProcessingException {
        return commentService.addNewComment(payloadJson);
    }
}

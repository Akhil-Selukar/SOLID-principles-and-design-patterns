package com.solid.principles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solid.principles.controller.CommentController;

public class Main {
    private static final String VALID_INPUT = """
                {
                    "message":"Valid comment",
                    "author":"John",
                    "postedOn": "2023-10-01T11:09:45.828+00:00"
                }""";

    private static final String INVALID_INPUT = """
                {
                    "message":"Valid comment",
                    "author":"",
                    "postedOn": "2023-10-01T11:09:45.828+00:00"
                }""";

    public static void main(String[] args) throws JsonProcessingException {
        CommentController commentController = new CommentController();
        String response = commentController.addNewComment(VALID_INPUT);
        if(!response.equalsIgnoreCase("SUCCESS")) {
            System.out.println("Failed");
        }
        System.out.println("Valid JSON received response: "+response);

        response = commentController.addNewComment(INVALID_INPUT);
        if(!response.equalsIgnoreCase("FAILURE")) {
            System.out.println("Failed");
        }
        System.out.println("Invalid JSON received response: "+response);
    }
}
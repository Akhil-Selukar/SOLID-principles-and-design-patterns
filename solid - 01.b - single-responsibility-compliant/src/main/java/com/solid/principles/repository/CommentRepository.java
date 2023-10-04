package com.solid.principles.repository;

import com.solid.principles.entity.Comment;

import java.util.HashMap;
import java.util.Map;

public class CommentRepository {
    private static final Map<String, Comment> DATABASE = new HashMap<>();
    public void save(Comment comment) {
        DATABASE.put(comment.getAuthor(), comment);
    }
}

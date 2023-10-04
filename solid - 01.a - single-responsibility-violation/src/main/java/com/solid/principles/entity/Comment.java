package com.solid.principles.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private String message;
    private String author;
    private Date postedOn;
}

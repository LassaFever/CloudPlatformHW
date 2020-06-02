package com.fish.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Article {

    private Long id;
    private String title;
    private String content;
    private List<Comment> comments;
}

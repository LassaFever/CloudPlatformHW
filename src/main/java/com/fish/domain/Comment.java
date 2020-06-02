package com.fish.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment {

    private Integer id;
    private String content;
    private String author;
    private Integer a_id;

}

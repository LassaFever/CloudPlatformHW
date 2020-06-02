package com.fish.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "t_comment")
@Table(name = "t_comment")
@Data
@ToString
public class Discuss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String content;

    @Column(name = "a_id")
    private Integer aId;
}

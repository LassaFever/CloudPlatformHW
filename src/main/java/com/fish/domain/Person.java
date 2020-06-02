package com.fish.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@RedisHash("Hash")
@Data
@ToString
public class Person {
    @Id
    private String id;

    @Indexed
    private String firstname;

    @Indexed
    private String lastname;

    private Address adress;

    private List<Family> familyList;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

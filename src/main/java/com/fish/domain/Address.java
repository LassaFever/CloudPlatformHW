package com.fish.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.redis.core.index.Indexed;

@Data
@ToString
@AllArgsConstructor
public class Address {

    @Indexed
    private String city;

    @Indexed
    private String country;

}

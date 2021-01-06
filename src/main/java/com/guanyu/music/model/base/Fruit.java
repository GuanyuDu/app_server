package com.guanyu.music.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * fruit model
 */
@Getter
@Setter
@ToString
public class Fruit {

    private String name;

    private Integer price;

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}

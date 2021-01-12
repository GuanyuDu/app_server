package com.guanyu.music.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * fruit model
 */
@Getter
@Setter
@ToString
public class Fruit {

    private Integer id;

    private String name;

    private BigDecimal price;

    public Fruit(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

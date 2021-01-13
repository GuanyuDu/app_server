package com.guanyu.app.model.base;

import lombok.*;

import java.math.BigDecimal;

/**
 * fruit model
 * @author Guanyu
 */

@Data
public class Fruit {

    private Integer id;

    private String name;

    private BigDecimal price;
}

package com.guanyu.music.service;

import com.guanyu.music.model.base.Fruit;

import java.util.List;

/**
 * @author guanyu
 */
public interface NormalService {

    /**
     * 打印输出
     */
    void printHi();

    /**
     * get all fruit
     * @return fruit of list
     */
    List<Fruit> getAllFruits();
}

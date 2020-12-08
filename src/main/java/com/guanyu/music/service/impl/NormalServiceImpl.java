package com.guanyu.music.service.impl;

import com.guanyu.music.service.NormalService;
import org.springframework.stereotype.Service;

/**
 * @author guanyu
 */
@Service
public class NormalServiceImpl implements NormalService {

    @Override
    public void printHi() {
        System.out.println("Hi");
    }
}

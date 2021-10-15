package com.guanyu.app.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author guanyu
 */
@Service
public class NormalService implements NormalService {

    @Override
    public void printHi() {
        System.out.println("Service, say hi!");
    }
}

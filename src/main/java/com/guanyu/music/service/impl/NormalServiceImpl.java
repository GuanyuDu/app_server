package com.guanyu.music.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guanyu.music.controller.NormalController;
import com.guanyu.music.mapper.FruitMapper;
import com.guanyu.music.model.base.Fruit;
import com.guanyu.music.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guanyu
 */
@Service
public class NormalServiceImpl implements NormalService {

    @Override
    public void printHi() {

        BigInteger a = new BigInteger("49800");
        BigInteger b = new BigInteger("19000");

        double val = b.doubleValue() / a.doubleValue() * 1000;

        System.out.println("result: ");

    }

    @Override
    public List<Fruit> getAllFruits() {

        return null;
    }
}

package com.guanyu.music.controller;

import com.guanyu.music.model.Result;
import com.guanyu.music.model.base.Fruit;
import com.guanyu.music.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guanyu
 */
@RestController
@RequestMapping("api/normal")
public class NormalController {

    private final NormalService normalService;

    @Autowired
    public NormalController(NormalService normalService) {
        this.normalService = normalService;
    }

    @GetMapping("/info")
    public Result<Object> testInfo(@RequestParam("id") Long id) {
        normalService.printHi();
        String s = String.format("Hi, Welcome to this project, Your id is %s", id);
        return Result.ok(s);
    }

    @GetMapping("/fruits")
    public Result<Object> getFruits() {
        return Result.ok();
    }
}

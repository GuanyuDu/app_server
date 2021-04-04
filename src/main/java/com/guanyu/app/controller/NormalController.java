package com.guanyu.app.controller;

import com.guanyu.app.model.base.Result;
import com.guanyu.app.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/no-param")
    public Result<Object> noParameter(String inParam) {
        return Result.ok(String.format("your param is : %s, don't add any annotation", inParam));
    }
}

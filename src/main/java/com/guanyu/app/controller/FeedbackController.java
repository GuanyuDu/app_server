package com.guanyu.app.controller;

import com.guanyu.app.model.base.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息反馈接口
 *
 * @author Guanyu
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping("")
    public Result<Object> addFeedback(@RequestParam String content) {

        return null;
    }
}

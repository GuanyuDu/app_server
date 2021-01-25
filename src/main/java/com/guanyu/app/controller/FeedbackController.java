package com.guanyu.app.controller;

import com.guanyu.app.model.base.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guanyu
 */
@RestController
@RequestMapping("api/feedback")
public class FeedbackController {

    @RequestMapping("/add")
    public Result<Object> addFeedback(@RequestParam String content) {

        return null;
    }
}

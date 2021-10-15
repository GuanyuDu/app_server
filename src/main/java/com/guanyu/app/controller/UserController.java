package com.guanyu.app.controller;

import com.guanyu.app.model.dto.base.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 *
 * @author Guanyu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户信息
     *
     * @param guid 用户id
     * @return 操作结果
     */
    @GetMapping("/{guid}/info")
    public Result<Object> getUserInfo(@PathVariable Long guid) {
        System.out.println("User info id: " + guid);

        return Result.ok(guid);
    }

    /**
     * 获取用户角色
     *
     * @param guid 用户id
     * @return 操作结果
     */
    @GetMapping("/{guid}/role")
    public Result<Object> getUserRole(@PathVariable Long guid) {
        System.out.println("User role guid: " + guid + ", role: guest");

        return Result.ok("guest");
    }

    /**
     * 用户反馈接口
     *
     * @param content 反馈内容
     * @return 操作结果
     */
    @PostMapping("/feedback")
    public Result<Object> createFeedback(@RequestParam String content) {

        return Result.ok();
    }
}

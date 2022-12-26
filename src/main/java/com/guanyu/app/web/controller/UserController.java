package com.guanyu.app.web.controller;

import com.guanyu.app.model.dto.UserDTO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户相关接口
 *
 * @author Guanyu
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserDTO> login(@RequestParam("token") String token) {
        return userService.login(token);
    }

    /**
     * 获取用户信息
     *
     * @param guid 用户id
     * @return 操作结果
     */
    @GetMapping("/{guid}/info")
    public Result<String> getUserInfo(@PathVariable Long guid) {
        System.out.println("User info id: " + guid);
        return Result.ok();
    }

    /**
     * 获取用户角色
     *
     * @param guid 用户id
     * @return 操作结果
     */
    @GetMapping("/{guid}/role")
    public Result<String> getUserRole(@PathVariable Long guid) {
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

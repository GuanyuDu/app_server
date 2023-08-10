package com.guanyu.app.web.controller;

import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


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

    /**
     * 静默登录
     *
     * @param code 微信授权码
     * @return token 用户登录凭证
     */
    @Operation(summary = "静默登录", description = "根据授权 code 进行登录")
    @GetMapping("/login")
    public Result<String> login(@RequestParam("code") String code) {
        return userService.login(code);
    }

    /**
     * 更新用户基础信息
     *
     * @return 空
     */
    @Operation(summary = "更新用户信息", description = "主要更新用户昵称、头像信息")
    @PostMapping("/info")
    public Result<Void> updateUserInfo(@RequestParam("nickname") String nickname,
                                       @RequestParam("avatar") String avatar) {
        return userService.updateBasicInfo(nickname, avatar);
    }

    /**
     * 获取当前登录用户基础信息
     *
     * @return 用户昵称、用户头像（如果存在）
     */
    @GetMapping("/info")
    public Result<String> getUserInfo() {
        //
        return Result.ok();
    }

    /**
     * 获取当前登录用户角色
     *
     * @return 操作结果
     */
    @GetMapping("/role")
    public Result<String> getUserRole() {
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

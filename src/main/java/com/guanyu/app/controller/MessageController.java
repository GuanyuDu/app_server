package com.guanyu.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.model.base.Result;
import com.guanyu.app.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 小程序消息列表接口
 *
 * @author Guanyu
 */
@RestController
@RequestMapping("api")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 获取指定消息
     *
     * @param id 消息id
     * @return 消息对象
     */
    @GetMapping("/messages/{id}")
    public Result<JSONObject> getMessage(@PathVariable String id) {
        System.out.println("Get message id: " + id);
        return Result.ok();
    }

    /**
     * 获取消息列表
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return 消息对象列表
     */
    @GetMapping("/messages")
    public Result<JSONObject> getMessages(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                          @RequestParam(required = false, defaultValue = "10") int pageSize) {
        System.out.println("Get messages currentPage: " + currentPage + " pageSize: " + pageSize);
        return Result.ok();
    }

    /**
     * 创建消息
     *
     * @param content 消息内容
     * @return
     */
    @PostMapping("/messages")
    public Result<JSONObject> createMessage(@RequestParam String content) {
        System.out.println("create message, content: " + content);
        return Result.ok();
    }

    @PutMapping("/messages")
    public Result<JSONObject> updateMessage() {
        System.out.println("update message");
        return Result.ok();
    }

    @PatchMapping("messages")
    public Result<JSONObject> updatePartOfMessage() {
        System.out.println("update message part");
        return Result.ok();
    }

    @DeleteMapping("/messages")
    public Result<JSONObject> deleteMessage() {
        System.out.println("delete message");
        return Result.ok();
    }

}

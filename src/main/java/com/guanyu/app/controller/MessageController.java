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
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 获取指定消息
     *
     * @param id 消息id
     * @return 消息对象
     */
    @GetMapping("/message/{id}")
    public Result<JSONObject> getMessage(@PathVariable Long id) {
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
    @GetMapping("/message")
    public Result<JSONObject> getMessages(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        System.out.println("Get messages currentPage: " + currentPage + " pageSize: " + pageSize);
        return Result.ok();
    }

    /**
     * 创建消息
     *
     * @param content 消息内容
     * @return 操作结果
     */
    @PostMapping("/message")
    public Result<JSONObject> createMessage(@RequestParam String content) {
        System.out.println("created message, content: " + content);
        return Result.ok();
    }

    /**
     * 删除消息
     *
     * @param id 消息 id
     * @return 操作结果
     */
    @DeleteMapping("/message/{id}")
    public Result<JSONObject> deleteMessage(@PathVariable Long id) {
        System.out.println("deleted message id: " + id);
        return Result.ok();
    }

}

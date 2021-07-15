package com.guanyu.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guanyu.app.model.base.PageInfo;
import com.guanyu.app.model.base.Result;
import com.guanyu.app.model.user.MessageDO;
import com.guanyu.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Guanyu
 */
@RestController
@RequestMapping("api")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 获取指定消息
     * @param id 消息id
     * @return 消息对象
     */
    @GetMapping("/messages/{id}")
    public Result<JSONObject> getMessage(@PathVariable String id) {
        return Result.ok();
    }

    /**
     * 获取消息列表
     * @param currentPage 当前页
     * @param pageSize 页大小
     * @return 消息对象列表
     */
    @GetMapping("/messages")
    public Result<JSONObject> getMessages(@RequestParam int currentPage, @RequestParam int pageSize) {
        return Result.ok();
    }

    /**
     * 创建消息
     * @param content 消息内容
     * @return
     */
    @PostMapping("/messages")
    public Result<JSONObject> createMessage(@RequestParam String content) {
        return Result.ok();
    }
}

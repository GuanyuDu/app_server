package com.guanyu.app.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guanyu.app.model.base.PageInfo;
import com.guanyu.app.model.base.Result;
import com.guanyu.app.model.user.Message;
import com.guanyu.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author Guanyu
 */
@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/list")
    public Result<Object> getMessage(@RequestParam int currentPage, @RequestParam int pageSize) {
        IPage<Message> messages = messageService.getMessages(currentPage, pageSize);
        return Result.ok(new PageInfo<>(messages));
    }

    @PostMapping("/add")
    public Result<Object> addMessage(@RequestParam String comment) {
        try {
            messageService.addMessage(comment);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "服务器内部错误");
        }
    }
}

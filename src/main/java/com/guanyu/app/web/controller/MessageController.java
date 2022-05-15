package com.guanyu.app.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 小程序消息列表接口
 *
 * @author Guanyu
 */
@Slf4j
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

        return Result.ok();
    }

    /**
     * 获取消息列表
     *
     * @param page  当前页
     * @param size  页大小
     * @return      消息对象列表
     */
    @GetMapping("/message")
    public Result<?> getMessages(@RequestParam(name = "page", required = false, defaultValue = "1") long page,
                                 @RequestParam(name = "size", required = false, defaultValue = "10") long size) {
        if (page < 1) {
            return Result.fail(ErrorCode.PARAM_TYPE_ERROR);
        }
        try {
            return Result.ok(messageService.getMessages(page, size));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(ErrorCode.UNKNOWN_ERROR);
    }

    /**
     * 创建消息
     *
     * @param content 消息内容
     * @return 操作结果
     */
    @PostMapping("/message")
    public Result<JSONObject> createMessage(@RequestParam(name = "reply_id", required = false, defaultValue = "0") Long replyId,
                                            @RequestParam String content) {
        messageService.addMessage(replyId, content);
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
//        messageService.delMessage(id);
        return Result.ok();
    }

}
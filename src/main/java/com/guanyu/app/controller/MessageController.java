package com.guanyu.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.model.dto.message.MessageDTO;
import com.guanyu.app.service.IMessageService;
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
    private IMessageService messageService;

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
            PageInfo<MessageDTO> messages = messageService.getMessages(page, size);
            return Result.ok(messages);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
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
    public Result<JSONObject> createMessage(@RequestParam(required = false, defaultValue = "0") Long replyId,
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
        messageService.delMessage(id);
        return Result.ok();
    }

}

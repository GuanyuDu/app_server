package com.guanyu.app.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.CommentDTO;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 小程序消息列表接口
 *
 * @author Guanyu
 */
@Slf4j
@Tag(name = "评论管理", description = "树洞的评论列表")
@RestController
public class CommentController {

    @Resource
    private CommentService commentService;


    /**
     * 获取消息列表
     *
     * @param page 当前页
     * @param size 页大小
     * @return 消息对象列表
     */
    @Operation(summary = "获取评论列表", description = "根据时间倒序返回用户评论数据，每次默认 10 条")
    @GetMapping("/comment")
    public Result<PageInfo<CommentDTO>> getComments(@RequestParam(name = "page", required = false, defaultValue = "1") long page,
                                                    @RequestParam(name = "size", required = false, defaultValue = "10") long size) {

        if (page < 1) return Result.fail(ErrorCode.PARAM_TYPE_ERROR);
        try {
            return Result.ok(commentService.getComments(page, size));

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
        return Result.fail(ErrorCode.UNKNOWN_ERROR);
    }

    /**
     * 检查当前评论功能是否可用
     *
     * @return Boolean true 表示可以评论，false 为不可评论
     */
    @Operation(summary = "检查评论功能是否可用", description = "获取当前评论功能状态，true 表示可评论")
    @GetMapping("/commentable")
    public Result<Boolean> commentable() {
        return Result.ok(commentService.commentable());
    }

    /**
     * 创建消息
     *
     * @param content 消息内容
     * @return 操作结果
     */
    @Operation(summary = "创建新评论")
    @PostMapping("/comment")
    public Result<Void> createComment(@RequestParam(name = "reply_id", required = false, defaultValue = "0") Long replyId,
                                      @RequestParam String content) {
        return commentService.addComment(replyId, content);
    }

    /**
     * 删除消息
     *
     * @param id 消息 id
     * @return 操作结果
     */
    @Operation(summary = "删除评论")
    @DeleteMapping("/comment/{id}")
    public Result<JSONObject> deleteComment(@PathVariable Long id) {
//        messageService.delMessage(id);
        return Result.ok();
    }

}

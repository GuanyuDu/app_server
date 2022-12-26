package com.guanyu.app.service;

import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.CommentDTO;
import com.guanyu.app.model.dto.base.Result;

/**
 * @author Guanyu
 */
public interface CommentService {

    /**
     * 首页评论列表
     *
     * @param page  当前页
     * @param size  页大小
     * @return      评论列表
     */
    PageInfo<CommentDTO> getComments(Long page, Long size);

    /**
     * 添加一条新评论
     *
     * @param replyId 回复id
     * @param comment 评论内容
     */
    Result<Void> addComment(long replyId, String comment);

    /**
     * 根据 id 删除评论
     *
     * @param id    评论 id
     */
    void delComment(long id);

    /**
     * 评论功能是否可用
     *
     * @return boolean true 表示可用
     */
    boolean commentable();
}

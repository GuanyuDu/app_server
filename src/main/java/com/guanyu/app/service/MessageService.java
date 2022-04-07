package com.guanyu.app.service;

import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.MessageDTO;

/**
 * @author Guanyu
 */
public interface MessageService {

    /**
     * 首页消息列表
     *
     * @param page  当前页
     * @param size  页大小
     * @return      消息列表
     */
    PageInfo<MessageDTO> getMessages(Long page, Long size);

    /**
     * 添加一条新消息
     *
     * @param replyId 回复id
     * @param comment 消息内容
     */
    void addMessage(long replyId, String comment);

    /**
     * 根据id删除消息
     *
     * @param id    消息id
     */
    void delMessage(long id);
}

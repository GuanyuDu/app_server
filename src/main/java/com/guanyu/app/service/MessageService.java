package com.guanyu.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guanyu.app.model.user.Message;

/**
 * @author Guanyu
 */
public interface MessageService {

    /**
     * get all message by page
     * @param currentPage current page number
     * @param pageSize per page size
     * @return message list
     */
    IPage<Message> getMessages(int currentPage, int pageSize);

    /**
     * add new message
     * @param comment message content
     */
    void addMessage(String comment);
}

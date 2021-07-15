package com.guanyu.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guanyu.app.mapper.MessageMapper;
import com.guanyu.app.model.user.MessageDO;
import com.guanyu.app.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 消息查询
 * @author Guanyu
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public IPage<MessageDO> getMessages(int currentPage, int pageSize) {
        // page
        IPage<MessageDO> page = new Page<>(currentPage, pageSize);
        // condition
        QueryWrapper<MessageDO> wrapper = new QueryWrapper<>();
        // get data
        return messageMapper.selectPage(page, wrapper);
    }

    @Override
    public void addMessage(String comment) {
        MessageDO messageDO = new MessageDO();
        messageDO.setComments(comment);
        messageDO.setCreateTime(new Date());
        messageMapper.insert(messageDO);
    }
}

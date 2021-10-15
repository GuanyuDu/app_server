package com.guanyu.app.service.impl;

import com.guanyu.app.constant.PageCons;
import com.guanyu.app.model.dao.MessageDao;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.miniapp.message.MessageDO;
import com.guanyu.app.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息查询
 * @author Guanyu
 */
@Service
public class MessageService implements IMessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Resource
    private MessageDao messageDao;


    @Override
    public PageInfo<MessageDO> getMessages(Long page, Long size) {

        long pageSize = Math.min(size, PageCons.DEFAULT_PAGE_SIZE);
        long offset = (page - 1) * pageSize;
        List<MessageDO> messages = messageDao.getMessages(offset, pageSize);

        return PageInfo.of(page, 10L, messages);
    }

    @Override
    public void addMessage(long replyId, String comment) {

        messageDao.addMessage(MessageDO.init(1L, replyId, comment));
    }

    @Override
    public void delMessage(long id) {

        int effectLine = messageDao.delMessage(id);
        if (effectLine <= 0) {
            throw new RuntimeException();
        }
    }
}

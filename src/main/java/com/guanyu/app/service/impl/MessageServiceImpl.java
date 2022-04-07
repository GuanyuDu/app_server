package com.guanyu.app.service.impl;

import com.guanyu.app.constant.PageCons;
import com.guanyu.app.manager.NotificationManager;
import com.guanyu.app.model.dao.MessageDao;
import com.guanyu.app.model.dao.UserDao;
import com.guanyu.app.model.dto.MessageDTO;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.miniapp.MessageDO;
import com.guanyu.app.model.miniapp.UserDO;
import com.guanyu.app.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息查询
 * @author Guanyu
 */

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private UserDao userDao;

    @Resource
    private MessageDao messageDao;

    @Resource
    private NotificationManager notificationManager;


    @Override
    public PageInfo<MessageDTO> getMessages(Long page, Long size) {

        long pageSize = Math.min(size, PageCons.DEFAULT_PAGE_SIZE);
        long offset = (page - 1) * pageSize;

        List<MessageDO> messages = messageDao.getMessages(offset, pageSize);
        Long totalCount = messageDao.getMessageCount();
        // the conversion of DO into DTO
        List<MessageDTO> result = messages.stream().map(message -> {
            UserDO userInfo = userDao.getUserInfoById(message.getUserId());
            return MessageDTO.init(message, userInfo);
        }).collect(Collectors.toList());

        return PageInfo.of(page, totalCount, result);
    }

    @Override
    public void addMessage(long replyId, String comment) {
        // 添加一条新消息
        messageDao.addMessage(MessageDO.init(1L, replyId, comment));
        // 发送通知
        notificationManager.feiShuRichTextNotification("新消息通知", "消息内容：" + comment,
                "详情", "https://api.dududu.top/message?page=1&size=10");
    }

    @Override
    public void delMessage(long id) {
        int effectLine = messageDao.delMessage(id);
        if (effectLine <= 0) {
            throw new RuntimeException();
        }
    }
}

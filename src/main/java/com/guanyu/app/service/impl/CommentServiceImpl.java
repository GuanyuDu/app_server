package com.guanyu.app.service.impl;

import com.guanyu.app.constant.PageCons;
import com.guanyu.app.manager.NotificationManager;
import com.guanyu.app.model.dao.CommentDao;
import com.guanyu.app.model.dao.UserDao;
import com.guanyu.app.model.dto.CommentDTO;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.miniapp.CommentDO;
import com.guanyu.app.model.miniapp.UserDO;
import com.guanyu.app.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    @Resource
    private UserDao userDao;

    @Resource
    private CommentDao commentDao;

    @Resource
    private NotificationManager notificationManager;


    @Override
    public PageInfo<CommentDTO> getComments(Long page, Long size) {

        long pageSize = Math.min(size, PageCons.DEFAULT_PAGE_SIZE);
        long offset = (page - 1) * pageSize;

        List<CommentDO> messages = commentDao.getComments(offset, pageSize);
        Long totalCount = commentDao.getCommentCount();
        // the conversion of DO into DTO
        List<CommentDTO> result = messages.stream().map(message -> {
            UserDO userInfo = userDao.getUserInfoById(message.getUserId());
            return CommentDTO.init(message, userInfo);
        }).collect(Collectors.toList());

        return PageInfo.of(page, totalCount, result);
    }

    @Override
    public void addComment(long replyId, String comment) {
        // 添加一条新消息
        commentDao.addComment(CommentDO.init(1L, replyId, comment));
        // 发送通知
        notificationManager.feiShuRichTextNotification("新消息通知", "消息内容：" + comment,
                "详情", "https://api.dududu.top/message?page=1&size=10");
    }

    @Override
    public void delComment(long id) {
        int effectLine = commentDao.delComment(id);
        if (effectLine <= 0) {
            throw new RuntimeException();
        }
    }
}

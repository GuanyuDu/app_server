package com.guanyu.app.service.impl;

import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.constant.PageCons;
import com.guanyu.app.manager.ConfigurationManager;
import com.guanyu.app.manager.NotificationManager;
import com.guanyu.app.model.dao.CommentDao;
import com.guanyu.app.model.dao.UserDao;
import com.guanyu.app.model.dto.CommentDTO;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.model.miniapp.CommentDO;
import com.guanyu.app.model.miniapp.UserDO;
import com.guanyu.app.service.CommentService;
import com.guanyu.app.util.log.Logs;
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
    @Resource
    private ConfigurationManager configurationManager;


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
    public Result<Void> addComment(long replyId, String content) {
        // 检查评论是否可用
        if (!configurationManager.commentable()) {
            Logs.detail.info("User submission of new comments is rejected. user_id = {}, content = '{}'", 0L, content);
            return Result.fail(ErrorCode.COMMENTS_NOT_AVAILABLE);
        }
        // TODO 添加一条新消息，用户标识获取
        commentDao.addComment(CommentDO.init(1L, replyId, content));
        // TODO 发送通知，如何快速审核新消息？
        notificationManager.feiShuRichTextNotification("新消息通知", "消息内容：" + content,
                "详情", "https://api.dududu.top/message?page=1&size=10");

        return Result.ok();
    }

    @Override
    public void delComment(long id) {
        int effectLine = commentDao.delComment(id);
        if (effectLine <= 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean commentable() {
        return configurationManager.commentable();
    }
}

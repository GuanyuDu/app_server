package com.guanyu.app.model.dao;

import com.guanyu.app.mapper.MessageMapper;
import com.guanyu.app.model.miniapp.message.MessageDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guanyu
 */
@Component
public class MessageDao {

    @Resource
    private MessageMapper messageMapper;

    /**
     * 根据置顶、热度获取消息列表
     *
     * @param offset    偏移值
     * @param size      页大小
     * @return          消息集合
     */
    public List<MessageDO> getMessages(Long offset, Long size) {
        return messageMapper.getMessages(offset, size);
    }

    /**
     * 插入一条新消息
     *
     * @param message 消息体
     */
    public void addMessage(MessageDO message) {
        messageMapper.insert(message);
    }

    /**
     * 根据 id 删除消息
     * @param id    消息id
     * @return      影响行数
     */
    public int delMessage(Long id) {
        return messageMapper.deleteById(id);
    }
}

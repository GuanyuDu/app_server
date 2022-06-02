package com.guanyu.app.model.dao;

import com.guanyu.app.model.mapper.CommentMapper;
import com.guanyu.app.model.miniapp.CommentDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论 Dao 层
 *
 * @author Guanyu
 */
@Component
public class CommentDao {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 根据置顶、热度获取评论列表
     *
     * @param offset {@link Long}   偏移值
     * @param size {@link Long}     页大小
     * @return CommentDOs           消息集合
     */
    public List<CommentDO> getComments(Long offset, Long size) {
        return commentMapper.getComments(offset, size);
    }

    /**
     * 获取可见评论总条数
     *
     * @return  可见评论总条数
     */
    public Long getCommentCount() {
        return commentMapper.getCommentCount();
    }

    /**
     * 插入一条新消息
     *
     * @param comment 消息体
     */
    public void addComment(CommentDO comment) {
        commentMapper.insert(comment);
    }

    /**
     * 根据 id 删除消息
     * @param id    消息id
     * @return      影响行数
     */
    public int delComment(Long id) {
        return commentMapper.deleteById(id);
    }
}

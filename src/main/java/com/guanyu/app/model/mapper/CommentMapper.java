package com.guanyu.app.model.mapper;

import com.guanyu.app.model.domain.CommentDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 消息表 mapper
 *
 * @author Guanyu
 */
public interface CommentMapper extends BaseMapper<CommentDO> {

    /**
     * 根据置顶、热度获取评论列表
     *
     * @param offset {@link Long}   偏移值
     * @param size {@link Long}     页大小
     * @return CommentDOs           消息集合
     */
    @Select("select * from `comment` where `status` = 1 order by `top_flag` desc, `create_time` desc limit ${offset}, ${size}")
    List<CommentDO> getComments(@Param("offset") Long offset, @Param("size") Long size);

    /**
     * 获取可见评论总条数
     *
     * @return total    可见消息总条数
     */
    @Select("select count(*) from comment where status = 1")
    Long getCommentCount();

}

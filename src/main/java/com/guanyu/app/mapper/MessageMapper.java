package com.guanyu.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.miniapp.message.MessageDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 消息表 mapper
 *
 * @author Guanyu
 */
public interface MessageMapper extends BaseMapper<MessageDO> {

    /**
     * 根据置顶、热度获取消息列表
     *
     * @param offset    偏移值
     * @param size      页大小
     * @return          消息集合
     */
    @Select("select * from mini_message order by top_flag desc, create_time desc limit ${offset}, ${size}")
    List<MessageDO> getMessages(@Param("offset") Long offset, @Param("size") Long size);

}

package com.guanyu.app.model.mapper;

import com.guanyu.app.model.domain.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户表 mapper
 *
 * @author Guanyu
 */
public interface UserMapper extends Mapper<UserDO> {

    @Select("select * from `user` where `id` in (${ids})")
    List<UserDO> getUserByIds(@Param("ids") String ids);
}

package com.guanyu.app.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.miniapp.user.UserDO;

/**
 * 用户表 mapper
 *
 * @author Guanyu
 */
@DS("mini_app")
public interface UserMapper extends BaseMapper<UserDO> {

}

package com.guanyu.app.model.dao;

import com.guanyu.app.mapper.UserMapper;
import com.guanyu.app.model.miniapp.UserDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Guanyu
 */
@Component
public class UserDao {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户id获取用户信息
     *
     * @param id    用户id
     * @return      用户信息
     */
    public UserDO getUserInfoById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * 插入一条新用户
     *
     * @param user  用户信息
     */
    public void addUserInfo(UserDO user) {
        userMapper.insert(user);
    }
}

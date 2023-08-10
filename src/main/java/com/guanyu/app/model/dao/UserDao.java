package com.guanyu.app.model.dao;

import com.guanyu.app.model.domain.UserDO;
import com.guanyu.app.model.mapper.UserMapper;
import com.guanyu.app.util.log.Logs;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * @param id 用户id
     * @return 用户信息
     */
    public UserDO getUserInfoById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<UserDO> getUserInfoByIds(List<Long> ids) {
        String idString = ids.stream().map(Object::toString).collect(Collectors.joining(","));
        return userMapper.getUserByIds(idString);
    }

    /**
     * 根据 openid 获取用户信息
     *
     * @param openid 用户 openid
     * @return {@link UserDO} 用户信息
     */
    public Optional<UserDO> getUserInfoByOpenid(String openid) {
        UserDO user = new UserDO();
        user.setOpenid(openid);
        return Optional.ofNullable(userMapper.selectOne(user));
    }

    /**
     * 添加或者修改一条用户
     *
     * @param user 用户信息
     */
    public void saveOrUpdate(UserDO user) {
        // 存在用户 id 直接更新
        if (Objects.nonNull(user.getId())) {
            int effectRows = userMapper.updateByPrimaryKey(user);
            Logs.debug.info("update user info return value is {}", effectRows);
            return;
        }
        int efRow = userMapper.insert(user);
        Logs.debug.info("insert user info return value is {}", efRow);
    }
}

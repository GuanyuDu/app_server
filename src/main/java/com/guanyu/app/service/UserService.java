package com.guanyu.app.service;


import com.guanyu.app.model.dto.UserDTO;
import com.guanyu.app.model.dto.base.Result;

/**
 * 用户相关接口
 *
 * @author Guanyu
 */
public interface UserService {

    /**
     * 用户登录流程
     *
     * @param token 微信登录 token
     * @return {@link Result} 用户基础信息
     */
    Result<UserDTO> login(String token);
}

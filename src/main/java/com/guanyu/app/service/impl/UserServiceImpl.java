package com.guanyu.app.service.impl;

import com.guanyu.app.model.dto.UserDTO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户相关接口
 *
 * @author Guanyu
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Result<UserDTO> login(String token) {
        return null;
    }
}

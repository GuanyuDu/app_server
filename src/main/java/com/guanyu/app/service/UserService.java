package com.guanyu.app.service;


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
     * @param code 微信登录 code
     * @return {@link Result} 用户基础信息
     */
    Result<String> login(String code);

    /**
     * 更新用户基础信息
     *
     * @param nickname 用户昵称
     * @param avatar   用户头像
     * @return 空
     */
    Result<Void> updateBasicInfo(String nickname, String avatar);
}

package com.guanyu.app.util;

import com.alibaba.fastjson.JSON;
import com.guanyu.app.model.domain.UserDO;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 用户信息 context
 *
 * @author Guanyu
 */
public class UserContext {

    /**
     * 用户信息
     */
    private static final ThreadLocal<UserInfo> USER_INFO = new ThreadLocal<>();

    /**
     * 初始化 UserContext
     */
    public static void init(String userInfoJson) {
        // 根据请求 token 获取用户基础信息并初始化 UserContext
        if (StringUtils.hasText(userInfoJson)) {
            USER_INFO.set(JSON.parseObject(userInfoJson, UserInfo.class));
        }
    }

    /**
     * 销毁 UserContext
     */
    public static void destroy() {
        USER_INFO.remove();
    }

    /**
     * 获取当前登录用户信息
     *
     * @return {@link UserInfo} 用户信息
     */
    private static Optional<UserInfo> getUserInfo() {
        return Optional.ofNullable(USER_INFO.get());
    }

    /**
     * 判断当前用户是否已经登录
     *
     * @return {@link Boolean} true：已登录，false：未登录
     */
    public static boolean isLogin() {
        return getUserInfo().isPresent();
    }

    /**
     * 获取当前登录用户 openid
     *
     * @return 用户 openid，未登录返回空串
     */
    public static String getOpenid() {
        return getUserInfo().map(UserInfo::getOpenid).orElse("");
    }

    /**
     * 获取当前登录用户昵称
     *
     * @return 用户昵称，未登录返回空串
     */
    public static String getNickname() {
        return getUserInfo().map(UserInfo::getNickname).orElse("");
    }


    @Getter
    public static class UserInfo {

        private final String nickname;
        private final String avatar;
        private final String openid;
        private final String sessionKey;

        public UserInfo(UserDO user, String sessionKey) {
            this.nickname = user.getNickname();
            this.avatar = user.getAvatar();
            this.openid = user.getOpenid();
            this.sessionKey = sessionKey;
        }

        public UserInfo(String nickname, String avatar, String openid, String sessionKey) {
            this.nickname = nickname;
            this.avatar = avatar;
            this.openid = openid;
            this.sessionKey = sessionKey;
        }
    }
}

package com.guanyu.app.model.user;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Guanyu
 */
@Data
public class User {

    private Long id;

    /**
     * 微信 OpenId
     */
    private String openid;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像 URL
     */
    private String cover;

    /**
     * 性别: 0: 未知, 1: 男, 2: 女
     */
    private int sex;

    /**
     * 国家
     */
    private String country;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

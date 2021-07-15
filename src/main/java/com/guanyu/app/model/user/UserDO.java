package com.guanyu.app.model.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@TableName(value = "user")
public class UserDO {

    private Long id;

    /**
     * 微信 OpenId
     */
    private String openId;

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
    private Integer sex;

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

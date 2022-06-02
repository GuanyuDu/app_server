package com.guanyu.app.model.miniapp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@TableName(value = "user")
public class UserDO extends BaseDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 微信 OpenId
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像 URL
     */
    private String avatar;

    /**
     * 性别: 0: 女, 1: 男, 2: 未知
     */
    private Integer sex;

}

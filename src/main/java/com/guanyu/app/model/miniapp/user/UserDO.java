package com.guanyu.app.model.miniapp.user;

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
@TableName(value = "mini_user")
public class UserDO {

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

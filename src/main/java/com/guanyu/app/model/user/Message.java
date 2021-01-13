package com.guanyu.app.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Guanyu
 */
@Data
public class Message {

    @TableId(type = IdType.AUTO)
    private BigInteger id;

    /**
     * 微信用户 OpenID
     */
    private BigInteger userOpenid;

    /**
     * 评论
     */
    private String comments;

    /**
     * 是否置顶: 1: 置顶, 0: 未置顶
     */
    private int top;

    /**
     * 点赞数
     */
    private int isLike;

    private Date createTime;

    private Date updateTime;
}

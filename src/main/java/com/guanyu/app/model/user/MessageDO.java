package com.guanyu.app.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * 信息实体
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@TableName(value = "message")
public class MessageDO {

    @TableId(type = IdType.AUTO)
    private BigInteger id;

    /**
     * 父级评论id
     */
    private BigInteger parentId;

    /**
     * 微信用户 OpenID
     */
    private BigInteger openId;

    /**
     * 评论
     */
    private String comments;

    /**
     * 是否置顶: 1: 置顶, 0: 未置顶
     */
    private Integer top;

    /**
     * 点赞数
     */
    private Integer isLike;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

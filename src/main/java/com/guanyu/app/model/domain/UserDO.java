package com.guanyu.app.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Guanyu
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "user")
public class UserDO extends BaseDO {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 微信 OpenId
     */
    private String openid;

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


    public UserDO(String openid) {
        this.openid = openid;
    }
}

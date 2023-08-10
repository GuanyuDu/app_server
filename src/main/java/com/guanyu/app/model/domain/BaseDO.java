package com.guanyu.app.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 基础字段类
 *
 * @author Guanyu
 */
@Getter
@Setter
public class BaseDO {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}

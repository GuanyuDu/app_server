package com.guanyu.app.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配置实体
 *
 * @author Guanyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "configuration")
public class ConfigurationDO extends BaseDO {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置分类
     */
    private String category;

    /**
     * 配置值
     */
    private String value;

    /**
     * 配置描述
     */
    private String description;
}

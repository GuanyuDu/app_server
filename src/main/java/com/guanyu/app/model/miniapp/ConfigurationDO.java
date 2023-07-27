package com.guanyu.app.model.miniapp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 配置实体
 *
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@TableName(value = "configuration")
public class ConfigurationDO extends BaseDO {

    @TableId(type = IdType.AUTO)
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

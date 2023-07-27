package com.guanyu.app.model.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.guanyu.app.model.mapper.ConfigurationMapper;
import com.guanyu.app.model.miniapp.ConfigurationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 配置表相关操作
 *
 * @author Guanyu
 */
@Component
public class ConfigurationDao {

    @Resource
    private ConfigurationMapper mapper;


    /**
     * 根据配置名称获取配置信息
     *
     * @param name 配置名称
     * @return ConfigurationDO 配置信息
     */
    public Optional<ConfigurationDO> getConfigByName(String name) {
        LambdaQueryWrapper<ConfigurationDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ConfigurationDO::getName, name);
        return Optional.ofNullable(mapper.selectOne(wrapper));
    }
}

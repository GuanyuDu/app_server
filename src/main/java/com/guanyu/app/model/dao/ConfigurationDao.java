package com.guanyu.app.model.dao;

import com.guanyu.app.model.domain.ConfigurationDO;
import com.guanyu.app.model.mapper.ConfigurationMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

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
        ConfigurationDO configuration = new ConfigurationDO();
        configuration.setName(name);
        return Optional.ofNullable(mapper.selectOne(configuration));
    }
}

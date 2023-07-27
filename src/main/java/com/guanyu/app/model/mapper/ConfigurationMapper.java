package com.guanyu.app.model.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.miniapp.ConfigurationDO;

/**
 * 配置表 Mapper
 *
 * @author Guanyu
 */
@DS("mini_app")
public interface ConfigurationMapper extends BaseMapper<ConfigurationDO> {

}

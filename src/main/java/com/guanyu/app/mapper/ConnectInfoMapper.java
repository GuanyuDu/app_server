package com.guanyu.app.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.toolbox.ConnectInfoDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Guanyuweb_tools
 */
@Component
@DS("mini_app")
public interface ConnectInfoMapper extends BaseMapper<ConnectInfoDO> {

    /**
     * 根据 type 和 env 查找实例名称
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @return 实例名称集合
     */
    @Select("select db_name from connect_info where type = #{type} and env = #{env}")
    List<String> getDatabaseByTypeAndEnv(Integer type, String env);

    /**
     * 获取连接信息
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @param dbName 数据库名
     * @return 实例名称集合
     */
    @Select("select * from  connect_info where type = #{type} and env = #{env} and db_name = #{dbName}")
    List<ConnectInfoDO> getConnectInfos(Integer type, String env, String dbName);

}

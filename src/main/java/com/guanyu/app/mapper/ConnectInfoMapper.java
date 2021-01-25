package com.guanyu.app.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guanyu.app.model.tool.ConnectInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Guanyuweb_tools
 */
@Component
@DS("web_tools")
public interface ConnectInfoMapper extends BaseMapper<ConnectInfo> {

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
    List<ConnectInfo> getConnectInfos(Integer type, String env, String dbName);

}

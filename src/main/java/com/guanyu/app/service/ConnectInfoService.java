package com.guanyu.app.service;

import com.guanyu.app.model.toolbox.dto.ConnectInfoDTO;

import java.util.List;

/**
 * @author Guanyu
 */
public interface ConnectInfoService {

    /**
     * 根据 type 和 env 查找实例名称
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @return 实例名称集合
     */
    List<String> getInstanceNameByTypeAndEnv(Integer type, String env);

    /**
     * 获取连接信息
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @param dbName 数据库名称
     * @return 实例名称集合
     */
    List<ConnectInfoDTO> getConnectInfos(Integer type, String env, String dbName);
}

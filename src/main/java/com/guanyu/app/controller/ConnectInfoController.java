package com.guanyu.app.controller;

import com.guanyu.app.model.base.Result;
import com.guanyu.app.model.dto.ConnectInfoDto;
import com.guanyu.app.service.ConnectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Guanyu
 */
@RestController
@RequestMapping("api/connect")
public class ConnectInfoController {

    ConnectInfoService connectInfoService;

    @Autowired
    public ConnectInfoController(ConnectInfoService connectInfoService) {
        this.connectInfoService = connectInfoService;
    }

    /**
     * 根据 type 和 env 查找实例名称
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @return 实例名称集合
     */
    @RequestMapping("/instances")
    public Result<Object> getInstanceNames(@RequestParam Integer type, @RequestParam String env) {

        List<String> instances = connectInfoService.getInstanceNameByTypeAndEnv(type, env);

        return Result.ok(instances);
    }

    /**
     * 获取连接信息
     * @param type 机器类型：0 跳板机，1 实例，2容器
     * @param env 环境标识：dev, uat, pro
     * @param database 数据库名称
     * @return 实例名称集合
     */
    @RequestMapping("/connect")
    public Result<Object> getConnectInfos(@RequestParam Integer type, @RequestParam String env, @RequestParam String database) {

        List<ConnectInfoDto> connectInfos = connectInfoService.getConnectInfos(type, env, database);

        return Result.ok(connectInfos);
    }
}

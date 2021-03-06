package com.guanyu.app.model.tool;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Guanyu
 */
@Data
public class ConnectInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 环境标识：dev, uat, pro
     */
    private String env;

    /**
     * 机器类型：0 跳板机，1 实例，2容器
     */
    private Integer type;

    /**
     * 服务器地址
     */
    private String host;

    /**
     * 服务端口
     */
    private Integer port;

    /**
     * 数据库名
     */
    private String dbName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 跳板机id
     */
    private Integer springboardId;
}

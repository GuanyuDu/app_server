package com.guanyu.app.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志枚举
 *
 * @author Guanyu
 */
public enum LogType {

    /**
     * 启动日志
     */
    BOOT("boot"),

    /**
     * 调试日志
     */
    DEBUG("debug"),

    /**
     * 数据明细日志
     */
    DETAIL("detail"),

    /**
     * 全链路日志
     */
    TRACE("trace"),

    /**
     * 警告日志
     */
    WARN("warn"),

    /**
     * 错误日志
     */
    ERROR("error");


    final Logger logger;

    LogType(String loggerName) {
        this.logger = LoggerFactory.getLogger(loggerName);
    }
}

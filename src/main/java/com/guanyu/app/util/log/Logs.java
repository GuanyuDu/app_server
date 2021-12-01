package com.guanyu.app.util.log;

import org.slf4j.Logger;

/**
 * 日志工具
 *
 * @author Guanyu
 */
public interface Logs {

    Logger boot = LogType.BOOT.logger;

    Logger debug = LogType.DEBUG.logger;

    Logger detail = LogType.DETAIL.logger;

    Logger trace = LogType.TRACE.logger;

    Logger warn = LogType.WARN.logger;

    Logger error = LogType.ERROR.logger;

}

package com.guanyu.app.util;

import java.time.format.DateTimeFormatter;

/**
 * 时间格式化工具
 *
 * @author Guanyu
 */
public final class TimeFormatHelper {

    public static final DateTimeFormatter YEAR_DASH = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter YEAR_NO_SYMBOL = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static final DateTimeFormatter TIME_COLON = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final DateTimeFormatter STANDARD = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}

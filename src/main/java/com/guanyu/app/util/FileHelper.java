package com.guanyu.app.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * 文件操作工具类
 * @author v.duguanyu
 */
public class FileHelper {

    /**
     * 获取文件对象
     * @param filePath 文件路径
     * @return 返回文件对象，如果未能获取文件对象返回 null
     */
    public static File getLocalFile(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }
}

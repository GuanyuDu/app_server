package com.guanyu.app.util;

import java.io.File;
import java.util.List;

/**
 * @author Guanyu
 */
public class ExportHelper {

    public static File createFile(String fileName, String path) {
        return new File(path + File.separator + fileName);
    }

    public <T> void writeFile(List<T> data) {

    }
}

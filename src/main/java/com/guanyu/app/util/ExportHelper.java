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

    public static void writeFile(File file) {
//        ExcelReader reader = EasyExcel.read(file).build();
    }

    public void writeFiles(List<File> files) {

    }
}

package com.guanyu.app.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.io.File;
import java.util.List;

/**
 * @author Guanyu
 */
public class ExportHelper {

    public static File createFile(String fileName, String path) {
        return new File(path + File.separator + fileName);
    }

    public static List writeFile(File file) {
        ExcelReader reader = EasyExcel.read(file).build();
    }

    public void writeFiles(List<File> files) {

    }
}

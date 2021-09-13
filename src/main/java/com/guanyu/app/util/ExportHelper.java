package com.guanyu.app.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author v.duguanyu
 */
public class ExportHelper {

    public static File createFile(String fileName, String path) {
        return new File("");
    }

    public <T> void writeFile(List<T> data) throws FileNotFoundException {

        File file = createFile("", "");
        FileOutputStream outputStream = new FileOutputStream(file);
        for (Object row : data) {
            if (row instanceof Integer) {

            } else if (row instanceof Long) {

            }
        }
    }
}

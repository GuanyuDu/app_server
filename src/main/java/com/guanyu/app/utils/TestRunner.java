package com.guanyu.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.guanyu.app.model.dto.TestDTO;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * test class
 * @author v.duguanyu
 */
@Component
public class TestRunner {

    @PostConstruct
    public void init() {

    }

    /**
     * 测试方法入口
     *
     * 1. 计算表尾缀：printTableSuffix()
     * 2. SQL生成工具：sqlGenerator()
     */
    public static void main(String[] args) {
        // call some method
        printTableSuffix(395876, 16, 80017755);

    }

    private void writeFile(SXSSFWorkbook workbook, File file) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 切面测试方法
     * @return String result
     */
    public static void testFunction() {
        String cbIdList = "123456 \n 893224\n390232\n2342342\n390232";
        String str = "8d4905cd931b55d8b470c9fcdb89ac07";
        String[] cbIds = cbIdList.split("\n");
        for (int i = 0;i < cbIds.length;i++) {
            cbIds[i] = cbIds[i].trim();
        }
        System.out.println(str.length());
        System.out.println(String.join(",", cbIds));
    }

    /**
     * SQL 生成工具 (待优化)
     */
    private static void sqlGenerator() {

        String fileNamePrefix = "export_";
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

        File file = new File("F:\\create_sql\\" + fileNamePrefix + time + ".sql");
        FileOutputStream outputStream = null;
        try {
            if (!file.exists()) {
                System.out.println("File not exists, created " + fileNamePrefix + time + "...");
                if (file.createNewFile()) {
                    System.out.println("Create file success!");
                } else {
                    System.out.println("Create failed, exit!");
                    return;
                }
            }
             outputStream = new FileOutputStream(file);

            String sql = "ALTER TABLE `change_log_%s` MODIFY COLUMN `distribution_type` tinyint(4) NULL COMMENT '0-默认 1-高级' AFTER `distribution_status`;";
            int order = 1;
            for (int i = 0; i < 100; i++) {
                String cbId = "9000388000300" + i;
                Integer hashCode = splitTableGenerator(cbId);
                outputStream.write(String.format(sql, i).getBytes());
                outputStream.write("\n".getBytes());
                order++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("[Attention] file not found");
        } catch (IOException e) {
            System.out.println("[Attention] io exception");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("[Attention] io exception");
                }
            }
        }
    }

    /**
     * 分表模拟工具
     */
    private static Integer splitTableGenerator(String param) {
        HashCode hashCode = Hashing.murmur3_128().hashString(param, StandardCharsets.UTF_8);
        return Math.abs(hashCode.asInt());
    }

    /**
     * 计算表尾缀
     * @param coId 公司 id
     * @param coopStatus 合作形态
     * @param appId 渠道 id
     */
    private static void printTableSuffix(long coId, int coopStatus, long appId) {
        Integer abs = splitTableGenerator(String.valueOf(coId + coopStatus + appId));
        System.out.println("[Table Suffix] " + abs % 100);
    }
}

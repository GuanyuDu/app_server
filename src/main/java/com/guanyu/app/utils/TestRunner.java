package com.guanyu.app.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * test class
 * @author v.duguanyu
 */
@Component
public class TestRunner {

    @PostConstruct
    public void init() {
        testFunction("dududu", 18);
    }

    /**
     * 测试方法入口
     *
     * 1. 计算表尾缀：printTableSuffix()
     * 2. SQL生成工具：sqlGenerator()
     */
    public static void main(String[] args) {
        // call some method
    }

    /**
     * 切面测试方法
     * @return String result
     */
    public String testFunction(String name, Integer age) {
        String out = String.format("[function output] name: %s, age: %s", name, age);
        System.out.println(out);
        return out;
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

            String sql = "CREATE TABLE distribution_cbid_%s LIKE distribution_cbid_0;";
            int order = 1;
            for (int i = 0; i < 99; i++) {
                String cbId = "9000388000300" + i;
                Integer hashCode = splitTableGenerator(cbId);
                outputStream.write(String.format(sql, order).getBytes());
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

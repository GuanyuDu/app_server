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

    public static void main(String[] args) {

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
     * SQL 生成工具
     */
    private static void sqlGenerator()  {

        String fileNamePrefix = "export_";
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

        File file = new File("F:\\create_sql\\" + fileNamePrefix + time + ".sql");
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
            FileOutputStream outputStream = new FileOutputStream(file);
            String sql = "INSERT INTO `yw_cp_open_book_distribution`.`rule_log` (`id`, `rule_id`, `coid`, `coop_status`, " +
                    "`app_id`, `version`, `remark`, `priority`, `type`, `expression`, `free_flag`, `charge_flag`, " +
                    "`month_subscribe_flag`, `operate_type`, `create_time`, `creator`, `update_time`) " +
                    "VALUES (NULL, %s, 90003, 8, 8000300, 1, 'test', 1, 1, '1.1&&1.2', 1, 2, 2, 1, '2021-04-02 22:26:42', 'Guanyu', '2021-04-02 22:36:36');";
            int ruleId = 100;
            for (int i = 0; i < 50; i++) {
                String cbId = "9000388000300" + i;
                String msgKey = splitTableGenerator(cbId);
                outputStream.write(String.format(sql, msgKey).getBytes());
                outputStream.write("\n".getBytes());
                ruleId++;
            }
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("[Attention] file not found");
        } catch (IOException e) {
            System.out.println("[Attention] io exception");
        }
    }

    /**
     * 分表模拟工具
     */
    private static String splitTableGenerator(String param) {
        HashCode hashCode = Hashing.murmur3_128().hashString(param, StandardCharsets.UTF_8);
        int abs = Math.abs(hashCode.asInt());
        System.out.println(abs % 100);
        return String.valueOf(abs);
    }
}

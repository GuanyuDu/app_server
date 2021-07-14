package com.guanyu.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.guanyu.app.model.dto.TestDTO;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;
import sun.net.www.http.HttpClient;

import javax.annotation.PostConstruct;
import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * test class
 *
 * @author v.duguanyu
 */
@Component
public class TestRunner {

    @PostConstruct
    public void init() {

    }

    /**
     * 测试方法入口
     * <p>
     * 1. 计算表尾缀：printTableSuffix()
     * 2. SQL生成工具：sqlGenerator()
     */
    public static void main(String[] args) throws IOException {
        // call some method
        FileReader fileReader = new FileReader("C:\\Users\\v.duguanyu\\Desktop\\new_text");
        BufferedReader buffer = new BufferedReader(fileReader);
        String s = buffer.readLine();
        System.out.println(new String(s.getBytes("windows-1252"), StandardCharsets.UTF_8));
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(32);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 切面测试方法
     *
     * @return String result
     */
    public static void testFunction() {
        String cbIdList = "123456 \n 893224\n390232\n2342342\n390232";
        String str = "8d4905cd931b55d8b470c9fcdb89ac07";
        String[] cbIds = cbIdList.split("\n");
        for (int i = 0; i < cbIds.length; i++) {
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
     *
     * @param coId       公司 id
     * @param coopStatus 合作形态
     * @param appId      渠道 id
     */
    private static void printTableSuffix(long coId, int coopStatus, long appId) {
        Integer abs = splitTableGenerator(String.valueOf(coId + coopStatus + appId));
        System.out.println("[Table Suffix] " + abs % 100);
    }
}

package com.guanyu.app.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.guanyu.app.constant.PageCons;
import com.guanyu.app.demo.pattern.TestBuilderPattern;
import com.guanyu.app.model.miniapp.UserDO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * test class
 *
 * @author Guanyu
 */
public class TestRunner {

    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 1000;

    private static final List<Future<?>> FUTURES = new ArrayList<>(64);

    /**
     * 测试方法入口
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(128), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        FUTURES.add(executor.submit(new Monitor()));
        FUTURES.add(executor.submit(new AsyncCat()));
        FUTURES.add(executor.submit(new AsyncDog()));

        Thread.sleep(1000);

        FUTURES.add(executor.submit(new AsyncCat()));

        executor.shutdown();

        TestBuilderPattern john = new TestBuilderPattern.Builder().name("john").age(18).habit("smoke").build();
        System.out.println(JSON.toJSONString(john));
    }

    public static class AsyncCat implements Runnable {

        @Override
        public void run() {
//            long testParameter = pageCons.getTestParameter();
            System.out.println("[Cat] get static parameter = " + PageCons.DEFAULT_PAGE_SIZE
                    + ", get testParameter = " + 0);
        }
    }

    public static class AsyncDog implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("[Dog] start modify parameters.");
//            pageCons.setTestParameter(pageCons.getTestParameter() + 6);
//            PageCons.DEFAULT_PAGE_SIZE += 8;

            System.out.println("[Dog] modify completed.");
            return "Completed";
        }
    }

    public static class Monitor implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("[Monitor] future size = " + FUTURES.size());
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void case1() throws IOException {
        // call some method
        Set<Long> result = new HashSet<>();

        FileReader reader = new FileReader("C:\\Users\\Guanyu\\Desktop\\demo.log");
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            List<Long> strings = JSON.parseArray(line).toJavaList(Long.class);
            result.addAll(strings);
        }
        File file = new File("C:\\Users\\Guanyu\\Desktop\\new.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (Long id : result) {
            bufferedWriter.write(id.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static Optional<UserDO> getUser(Long id) {
        UserDO user = new UserDO();
        user.setId(id);
        return Optional.of(null);
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(32);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

//    private void writeFile(SXSSFWorkbook workbook, File file) {
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            workbook.write(outputStream);
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

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

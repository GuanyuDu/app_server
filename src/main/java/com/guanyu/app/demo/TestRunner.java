package com.guanyu.app.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.guanyu.app.config.TestConfig;
import com.guanyu.app.model.miniapp.UserDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * test class
 *
 * @author Guanyu
 */
@Component
public class TestRunner {

    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 1000;

    private static final List<Future<?>> FUTURES = new ArrayList<>(64);

    @Resource
    private TestConfig testConfig;

    @PostConstruct
    private void init() {
        System.out.println(testConfig.data);
    }

    /**
     * 测试方法入口
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(128), threadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        Thread.sleep(1000);
//
//        executor.shutdown();

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

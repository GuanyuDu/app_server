package com.guanyu.app.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author Guanyu
 */
@Component
public class TaskRunner implements ApplicationRunner {

    private ArrayList<Future<String>> futures = new ArrayList<>();

    public static void main(String[] args) {
        String url = "jdbc:mysql://106.52.123.178:3306/mini_app?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
        String username = "miniapp";
        String password = "Pma+911105";
        String sql = "select * from `comment`";
        String testSql = "select count(*) from `comment`";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @SneakyThrows
                @Override
                public void run() {
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(testSql)) {
                        while (resultSet.next()) {
                            System.out.println(LocalTime.now() + " - " + resultSet.getString(1));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 301 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        // do something
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("default-thread-%d")
                .build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(128), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        Future<String> future = executor.submit(() -> {

            return "";
        });
        futures.add(future);

    }

}

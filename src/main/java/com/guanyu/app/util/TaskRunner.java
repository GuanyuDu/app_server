package com.guanyu.app.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Guanyu
 */
@Component
public class TaskRunner implements ApplicationRunner {

    private ArrayList<Future<String>> futures = new ArrayList<>();

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

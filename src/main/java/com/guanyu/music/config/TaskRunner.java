package com.guanyu.music.config;

import com.guanyu.music.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author v.duguanyu
 */
@Component
public class TaskRunner implements ApplicationRunner {

    private final NormalService normalService;

    @Autowired
    public TaskRunner(NormalService normalService) {
        this.normalService = normalService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // do something
    }
}

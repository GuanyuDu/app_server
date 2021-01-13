package com.guanyu.app.config;

import com.guanyu.app.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        normalService.printHi();
    }
}
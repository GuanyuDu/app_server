package com.guanyu.app.config;

import com.guanyu.app.util.TestRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author v.duguanyu
 */
@Component
public class TaskRunner implements ApplicationRunner {

    @Resource
    TestRunner testRunner;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // do something
    }

}

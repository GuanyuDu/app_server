package com.guanyu.app.config;

import com.guanyu.app.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

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

//        LocalDate localDate = LocalDate.of(2018, 10, 1);
//
//        LocalDate nowDate = LocalDate.now();
//
//        System.out.println(nowDate.toEpochDay() - localDate.toEpochDay());
//
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
//        DateTimeFormatter dtf;
//        String date;
//
//        dateTime = dateTime.plusDays(-5);
//        System.out.println(dateTime);
//
//        LocalDateTime with = dateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
//        System.out.println(with);
    }
}

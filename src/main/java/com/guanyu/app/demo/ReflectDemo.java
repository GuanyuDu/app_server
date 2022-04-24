package com.guanyu.app.demo;

import com.guanyu.app.demo.pattern.TestBuilderPattern;

import java.lang.reflect.Field;

public class ReflectDemo {

    public static void main(String[] args) throws IllegalAccessException {
        TestBuilderPattern test = new TestBuilderPattern.Builder().age(18).name("Sari").habit("reading").build();
        Class<? extends TestBuilderPattern> testClass = test.getClass();
        for (Field field : testClass.getFields()) {
            if (field.getType().isAssignableFrom(int.class)) {
                int age = field.getInt(test);
                System.out.println(age);
            }
        }
    }
}

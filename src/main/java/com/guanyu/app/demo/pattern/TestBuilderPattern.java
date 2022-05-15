package com.guanyu.app.demo.pattern;

import lombok.ToString;

/**
 * @author Guanyu
 */
@ToString
public class TestBuilderPattern {

    public final String name;
    public final transient int age;
    public final String habit;

    private TestBuilderPattern(String name, int age, String habit) {
        this.name = name;
        this.age = age;
        this.habit = habit;
    }

    public static class Builder {
        private String name;
        private int age;
        private String habit;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder habit(String habit) {
            this.habit = habit;
            return this;
        }

        public TestBuilderPattern build() {
            return new TestBuilderPattern(name, age, habit);
        }
    }
}

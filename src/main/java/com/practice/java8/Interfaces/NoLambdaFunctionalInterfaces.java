package com.practice.java8.Interfaces;

import java.util.function.Predicate;

public class NoLambdaFunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("A");
            }
        };
        System.out.println(predicate.test("Amulya"));
        System.out.println(predicate.test("mee"));
    }
}

package com.practice.java8.Lambda;

public class LambdaExpressions {
    public static void main(String[] args) {
        Calculator calculator=(a,b)->a+b;


        System.out.println(calculator.calc(1,2));

        Creator creator=()->"hello";
        System.out.println(creator.create());

        Tester tester=s->s.length()>5;
        System.out.println(tester.test("Amul"));
    }
}

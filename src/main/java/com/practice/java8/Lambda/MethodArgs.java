package com.practice.java8.Lambda;

public class MethodArgs {
    public static void main(String[] args) {
        System.out.println(runTester(str->str.length()>5,"Amulya"));
        System.out.println(runTester(str->str.startsWith("p"),"Amulya"));
    }

    public static boolean runTester(Tester t,String str){
        return  t.test(str);
    }
}

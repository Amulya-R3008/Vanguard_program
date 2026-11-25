package com.practice.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;

public class ImmutabilityDemo {
    public static void main(String[] args) {
        List<String> skills = Arrays.asList("java","spring");
        ImmutableEmployee e1=new ImmutableEmployee("amu",400000,skills);

        //create new obj emp1 unchanged
        ImmutableEmployee e2=e1.withSalary(10000);
        System.out.println(e1.getSalary());//unchanged
        System.out.println(e2.getSalary());//changed

        // Thread safety demonstration
        // Multiple threads can read emp1 simultaneously
        // No synchronization needed because emp1 CANNOT change
    }
}

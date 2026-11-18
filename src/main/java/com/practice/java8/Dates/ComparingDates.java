package com.practice.java8.Dates;

import java.time.LocalDateTime;

public class ComparingDates {
    public static void main(String[] args) {
        LocalDateTime l1=LocalDateTime.now();
        LocalDateTime l2=LocalDateTime.of(2002,8,30,1,3);
        System.out.println(l1.compareTo(l2));

        System.out.println("is after:"+l1.isAfter(l2));
        System.out.println("is before :"+l1.isBefore(l2));
        System.out.println("is equal:"+l1.isEqual(l2));
    }
}

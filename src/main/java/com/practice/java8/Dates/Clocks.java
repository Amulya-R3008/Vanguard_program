package com.practice.java8.Dates;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class Clocks {
    public static void main(String[] args) {
        Clock c=Clock.systemDefaultZone();
        System.out.println(c);

        Instant i=c.instant();
        System.out.println(i);

        Clock c1=Clock.systemUTC();
        System.out.println(c1.instant());

        Clock c2=Clock.offset(c, Duration.ofHours(10));
        System.out.println(c2.instant());
    }
}

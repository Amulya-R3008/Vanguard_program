package com.practice.java8.Dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class ZonesAndDates {
    public static void main(String[] args) {
//        for(String zoneId: ZoneId.getAvailableZoneIds()) {
//            //System.out.println(zoneId);
//            ZoneId z=ZoneId.of(zoneId);
//            String s= z.getDisplayName(TextStyle.FULL, Locale.US);
//            System.out.println(z+" : "+s);
//        }

        ZoneId z=ZoneId.of("America/Los_Angeles");
        LocalDateTime l1=LocalDateTime.now();
        ZonedDateTime z1=ZonedDateTime.of(l1,z);
        System.out.println(z1);

        ZonedDateTime z2=l1.atZone(z);
        System.out.println(z2);

        ZonedDateTime z4=ZonedDateTime.now();
        System.out.println(z4.getZone());

    }
}

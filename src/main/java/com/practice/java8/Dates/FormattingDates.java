package com.practice.java8.Dates;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDates {
    public static void main(String[] args) {
        LocalDateTime ldt=LocalDateTime.now();
        String formattedDate = DateTimeFormatter.BASIC_ISO_DATE.format(ldt);
        System.out.println(formattedDate);
        DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(f.format(ldt));

        String formattedDate1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(ldt);
        System.out.println(formattedDate1);
    }
}

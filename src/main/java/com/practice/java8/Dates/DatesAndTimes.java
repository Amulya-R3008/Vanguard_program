package com.practice.java8.Dates;

import java.time.*;

public class DatesAndTimes {
    public static void main(String[] args) {
        //date
        LocalDate l1= LocalDate.now();
        LocalDate l2= LocalDate.of(2002,8,30);
        LocalDate l3= LocalDate.of(2002, Month.AUGUST,30); //used enums in place of month

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        //invalid date
        //LocalDate l4=LocalDate.of(2024,13,01);
        //System.out.println(l4);


        //time
        LocalTime t1= LocalTime.now();
        LocalTime t2=LocalTime.of(10,5);
        System.out.println(t1);
        System.out.println(t2);

        //date and time
        LocalDateTime lt1=LocalDateTime.now();
        LocalDateTime lt2=LocalDateTime.of(2002,8,30,10,5);
        LocalDateTime lt3=LocalDateTime.of(l1,t1);
        System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(lt3);

        //monthday
        MonthDay monthDay=MonthDay.of(Month.AUGUST,30);
        LocalDate newLocalDate = monthDay.atYear(2002);

        //yearmonth
        YearMonth month=YearMonth.now();
        LocalDate n=month.atDay(8);

        System.out.println(monthDay);
        System.out.println(newLocalDate);
        System.out.println(month);
        System.out.println(n);
    }
}

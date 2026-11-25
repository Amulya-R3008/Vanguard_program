package com.practice.java8.FunctionalProgramming;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PureFunction {
    //pure function - depends only on object
    public static int add(int a, int b){
        return  a+b;

    }

    //pure function - no external dependency
    public static double calculateTax(double income,double taxRate){
        return  income*taxRate;
    }

    //pure function - transforms data, returns new list
    public static List<String> toUpperCase(List<String> names){
        List<String> result=new ArrayList<>();
        for(String name:names){
            result.add(name.toUpperCase());
        }
        return result;
    }

    //impure func (BAD)
    private static int counter =0;
    //impure - modifies external state
    public static int incrementCounter(){
        counter++;//side effect:modifies external variable
        return counter;
    }

    //impure - depends on external state
    public static double calculatePrice(double basePrice){
        //reading from external source db
        double discount = getDiscountFromDB(); //side effect
        return basePrice-discount;
    }

    //impure - I/O operation
    public static void logMessage(String  message){
        System.out.println(message); //side effect : I/O
    }

    //impure - depends on current time
    public static String getGreeting(){
        int hour = LocalTime.now().getHour();
        if(hour<12){
            return "good morning";
        }
        return  "good afternoon";
    }
    private  static double getDiscountFromDB(){
        return 10.0;
    }

    public static void main(String[] args) {
        //pure function - always same result
        System.out.println(add(2,3));
        System.out.println(add(2,3));

        //impure function - different result
        System.out.println(incrementCounter());
        System.out.println(incrementCounter());
    }
}

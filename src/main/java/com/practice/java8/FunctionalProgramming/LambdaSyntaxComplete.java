package com.practice.java8.FunctionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaSyntaxComplete {
    public static void main(String[] args) {
        //no parameters
        Runnable r1=()-> System.out.println("Hello World");
        Runnable r2=()->{
            System.out.println("multiple");
            System.out.println("statements");
        };

        r1.run();
        r2.run();
        //single parameter
        //parentheses is optional for single param
        Consumer<String> c1= s-> System.out.println(s);
        Consumer<String> c2=(s)-> System.out.println(s);
        //with explicit type
        Consumer<String> c3=(String s) -> System.out.println(s);
        c1.accept("hi");
        c2.accept("hi");

        //multiple statements
        //parentheses required
        BiFunction<Integer,Integer,Integer> add=(a,b)->a+b;
        BiFunction<Integer, Integer, Integer> add2 =
                (Integer a, Integer b) -> a + b;
        // CANNOT mix: (Integer a, b) -> a + b  // COMPILE ERROR
        add.apply(10,10);
        add2.apply(10,10);

        //return value
        //single expression - implicit return
        Function<Integer,Integer> square = x->x*x;
        square.apply(10);

        //multiple statements - explicit return required
        Function<Integer,Integer> complex=x->{
            int result = x*x;
            result =result+10;
            return  result;//must have return
        };
        complex.apply(10);

        //effectively final variable capture
        String prefix ="Hello";//effectively final
        //prefix = "changed"; If uncommented, lambda below won't compile

        Consumer<String> greeter = name-> System.out.println(prefix+" "+name);
        greeter.accept("Hi");

        //lambda with exceptions
        //checked exception needs to be handled inside lambda
        //or use a custom functional interface
        Function<String , Integer> parseUnsafe = s->{
            try{
                return Integer.parseInt(s);
            }catch (NumberFormatException e){
                return 0;
            }
        };
        parseUnsafe.apply("Hello");
    }
}

package com.practice.java8.FunctionalProgramming;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        //1.Function<T,R> - Takes T, returns R
        //abstract method R apply(T t)

        Function<String,Integer> stringlength = s->s.length();
        System.out.println(stringlength.apply("hello"));

        Function<String,String > uppercase = a->a.toUpperCase();
        System.out.println(uppercase.apply("hello"));

        Function<Integer,Integer> doubleIt= n->n*2;
        Function<Integer,Integer> addTen=n->n+10;

        //compose: addTen run first then doubleIt
        //doubleIt(addTen(5)) = doubleIt(15) = 30
        Function<Integer,Integer> composed = doubleIt.compose(addTen);
        System.out.println(composed.apply(5));

        //andThen : doubleIt run first and then addTen
        //addTen(doubleIt(5)) = addTen(10) = 20
        Function<Integer,Integer> addThen = doubleIt.andThen(addTen);
        System.out.println(addThen.apply(5));

        //Identity : returns input as-is
        Function<String , String > identity = Function.identity();
        System.out.println(identity.apply("hello"));

        //Bi-Function<T,U,R> - takes T, U and returns R
        //R apply(T t, U u)
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a+b;
        System.out.println(add.apply(5, 10));

        BiFunction<String,String,String> concat = (a,b)->a+" "+b;
        System.out.println(concat.apply("hello","world"));

        BiFunction<String,Integer,String> repeat = (s,n)->s.repeat(n);
        System.out.println(repeat.apply("Ha",3));

        //predicate<T> - takes T, returns boolean
        // boolean test(T t)
        Predicate<Integer> isEven = n->n%2 ==0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));

        Predicate<String> isNotEmpty = s->!s.isEmpty();
        Predicate<String > startsWithJ = s->s.startsWith("J");

        //and - both cond must be true
        Predicate<String> startsWithJNotEmpty = isNotEmpty.and(startsWithJ);
        System.out.println(startsWithJNotEmpty.test("John"));
        System.out.println(startsWithJNotEmpty.test("amulya"));

        //or - at least pne cond must be true
        Predicate<String> isLong = s->s.length()>5;
        Predicate<String> startsJOrLong = startsWithJ.or(isLong);
        System.out.println(startsJOrLong.test("Jo"));
        System.out.println(startsJOrLong.test("amulya"));

        //negate - reverse the cond
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(5));

        //isEqual - checks equality
        Predicate<String > isHello = Predicate.isEqual("Hello");
        System.out.println(isHello.test("Hello"));

        //BiPredicate<T,U> - takes T and U, returns boolean
        //boolean test(T t, U u)
        BiPredicate<String ,Integer> isLongerThan = (s, len) ->s.length()>len;
        System.out.println(isLongerThan.test("hello",3));
        System.out.println(isLongerThan.test("hi",3));

        //consumer<T> - takes T, returns nothing (void)
        //void accept(T t)
        Consumer<String> print = s->System.out.println(s);
        print.accept("hello consumer");

        Consumer<String> printUpper = s->System.out.println(s.toUpperCase());
        printUpper.accept("hello consumer");

        //andThen - chain consumer
        Consumer<String> printBoth = print.andThen(printUpper);
        printBoth.accept("hello consumer");

        //real world : logging and sending notifications
        Consumer<String> logger = msg-> System.out.println("[LOG]"+ LocalDateTime.now()+":"+msg);
        logger.accept("application started");

        //BiConsumer<T,U> - takes T and U returns nothing
        //void accept(T t,U u)
        BiConsumer<String,Integer> printNameAge=(name,Age)-> System.out.println(name+" is "+Age);
        printNameAge.accept("amulya",24);

        //real world: populating maps
        BiConsumer<Map<String,Integer>, String > addToMap = (map,key) -> map.put(key,key.length());
        Map<String,Integer> wordLengths = new HashMap<>();
        addToMap.accept(wordLengths,"hello");
        addToMap.accept(wordLengths,"world");
        System.out.println(wordLengths);

        //supplier<T> - takes nothing, returns T
        //T get()
        Supplier<String > greeting = ()->"hello world";
        System.out.println(greeting.get());

        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println(randomNumber.get());

        Supplier<List<String >> listFactory = () -> new ArrayList<>();
        List<String> newList =listFactory.get();
        System.out.println(newList);

        //real world : lazy initialization
//        Supplier<DatabaseConnection> dbconnection= ()->{
//            System.out.println("database connection established");
//            return new DatabaseConnection;
//        };
        // Connection is NOT created until get() is called


        //unaryOperator<T> - takes T,returns T(same type)
        //extends function<T,T>
        //T apply(T t)
        UnaryOperator<String> toUpperOp = s->s.toUpperCase();
        System.out.println(toUpperOp.apply("hello"));

        UnaryOperator<Integer> square = n->n*n;
        System.out.println(square.apply(5));

        //used with List.replaceAll
        List<String> names = new ArrayList<>(Arrays.asList("John","amulya"));
        names.replaceAll(String::toUpperCase);
        System.out.println(names);

        //BinaryOperator<T> - takes T and T, returns T
        //extends BiFunction<T,T,T>
        //T apply(T t1,T t2)

        BinaryOperator<Integer> sum =(a,b)->a+b;
        System.out.println(sum.apply(5,5));

        BinaryOperator<String> concatOp = (a,b) -> a+b;
        System.out.println(concatOp.apply("hello","world"));

        //minBy and maxBy
        BinaryOperator<Integer> max = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println(max.apply(5,3));

        BinaryOperator<Integer> min = BinaryOperator.minBy(Integer::compareTo);
        System.out.println(min.apply(5,3));

    }
}

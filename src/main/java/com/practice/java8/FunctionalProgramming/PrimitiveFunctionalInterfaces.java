package com.practice.java8.FunctionalProgramming;

import java.util.function.*;

public class PrimitiveFunctionalInterfaces {
    public static void main(String[] args) {
        //IntFunction, LongFunction, DoubleFunction
        //avoids autoboxing overhead

        IntFunction<String > intToString = i->"Number: " +i;
        System.out.println(intToString.apply(5));

        //ToIntFunction, ToLongFunction, ToDoubleFunction
        ToIntFunction<String> stringToLength = s-> s.length();
        System.out.println(stringToLength.applyAsInt("Number"));

        //IntPredicate, LongPredicate, DoublePredicate
        IntPredicate isPositive = n->n>0;
        System.out.println(isPositive.test(6));
        System.out.println(isPositive.test(-1));

        //IntConsumer, LongConsumer, DoubleConsumer
        IntConsumer printInt = n-> System.out.println("value: "+n);
        printInt.accept(6);

        //IntSupplier, LongSupplier, DoubleSupplier
        IntSupplier randomInt = () -> (int) (Math.random()*100);
        System.out.println(randomInt.getAsInt());

        //IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
        IntUnaryOperator doubleIt = n->n*2;
        System.out.println(doubleIt.applyAsInt(5));

        //IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
        IntBinaryOperator intSum = (a,b)->a+b;
        System.out.println(intSum.applyAsInt(5,5));
    }
}

package com.practice.java8.Optionals;

import java.util.Optional;

public class ChallengeOptionals {
    public static void main(String[] args) {
        // 1 create an empty optional of type string
        Optional<String> stringOptional = Optional.empty();

        //2 create an optional containing an integer
        Optional<Integer> integerOptional=Optional.of(31);

        //3 get value out of empty optional and specify a default name
        stringOptional.orElse("Hello");

        //4 filter integer optional and only keep odd values after that get the values or throw runtime exception
        integerOptional.filter(i->i%2!=0).orElseThrow(()->new RuntimeException());

        //5 map integer to be 1 higher and get the value out
        integerOptional.map(i->i+1).get();
    }
}

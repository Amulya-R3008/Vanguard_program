package com.practice.java8.StreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingParallel {
    public static void main(String[] args) {
        //different outcome with parallel stream
        int total = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .parallel()
                .reduce(1,(a,b)->a+b);
        System.out.println(total);

        //performance test
        String[] names={"Amulya","Shwetha","Rohan","Bhoomika","Amruthesh","Aditya"};

        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        long startpar = System.currentTimeMillis();
        nameList.parallelStream().filter(s->s.startsWith("A")).forEach(System.out::println);
        long endpar = System.currentTimeMillis();
        System.out.println("time parallel took :"+(endpar-startpar));

        long startSeq = System.currentTimeMillis();
        nameList.stream().filter(s->s.startsWith("A")).forEach(System.out::println);
        long endSeq = System.currentTimeMillis();
        System.out.println("time seq took :"+(endSeq-startSeq));


    }
}

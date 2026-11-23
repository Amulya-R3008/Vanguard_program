package com.practice.java8.StreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        String[] names={"Amulya","Shwetha","Rohan","Bhoomika","Amruthesh","Aditya"};

        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        //filter
        nameList.stream().filter(name->name.startsWith("A")).forEach(System.out::println);

        //map
        nameList.stream().map(s->s+" Student").forEach(System.out::println);

        //flatmap
        String[][] names2d={names,names};
        String[] names1d = Stream.of(names2d).flatMap(a->Stream.of(a)).toArray(size->new String[size]);
        for(String name:names1d){
            System.out.println("1 d arr: "+ name);
        }

        for(String name:names1d) {
            System.out.println("1 d arr: " + name);
        }
        //peek
        String[] namesoned = Stream.of(names2d)
                .flatMap(a->Stream.of(a))
                .peek(s-> System.out.println("peek:"+s))
                .toArray(size->new String[size]);
        for(String name:namesoned) {
            System.out.println("arr: " + name);
        }

        //skip
        Arrays.stream(names1d).skip(1).forEach(s-> System.out.println("skip:"+s));

        //limit
        Arrays.stream(names1d).limit(1).forEach(s-> System.out.println("limit:"+s));

        //skip and limit
        Arrays.stream(names1d).skip(2).limit(5).forEach(s-> System.out.println("skip and limit:"+s));

        //distinct
        long nrOfDistinctValues = Arrays.stream(names1d).distinct().count();
        System.out.println("distinct values :" +nrOfDistinctValues);

        //sorted
        Arrays.stream(names1d).sorted().forEach(s-> System.out.println("sorted:"+s));
    }

}

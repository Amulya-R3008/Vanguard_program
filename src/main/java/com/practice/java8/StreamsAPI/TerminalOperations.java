package com.practice.java8.StreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        String[] names={"Amulya","Shwetha","Rohan","Bhoomika","Amruthesh","Aditya"};

        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        Arrays.stream(names).forEach(name->System.out.println(name));
        Arrays.stream(names).forEach(System.out::println);

        Optional<String> r=Arrays.stream(names).min((a, b)->a.compareTo(b));
        System.out.println(r);

        boolean re=nameList.stream().allMatch(name->!name.isEmpty());
        System.out.println("not empty:"+re);

        boolean res=nameList.stream().allMatch(name->name.startsWith("M"));
        System.out.println("starts with m:"+res);

         List<String> LengthLongerThan5 = nameList.stream().filter(name->name.length()>5).collect(Collectors.toList());
        System.out.println("length:"+LengthLongerThan5);

        int[] ints={1,2,3,4};
        int total=Arrays.stream(ints).reduce(0,(a,b)->a+b);
        System.out.println(total);

    }
}

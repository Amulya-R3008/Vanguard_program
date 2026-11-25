package com.practice.java8.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableEmployee {
    private final  String name;
    private final int salary;
    private final List<String> skills; //mutable collection needs care
    public ImmutableEmployee( String name, int salary, List<String> skills){

        this.name = name;
        this.salary = salary;
        //defensive copy critical for immutability
        this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    //instead of modifying new object returned
    public ImmutableEmployee withSalary(int newsalary){
        return new ImmutableEmployee(this.name,newsalary,this.skills);
    }

    public ImmutableEmployee withSkills(String skill){
        List<String> skillList = new ArrayList<>(this.skills);
        skillList.add(skill);
        return new ImmutableEmployee(this.name,this.salary,skillList);
    }
}

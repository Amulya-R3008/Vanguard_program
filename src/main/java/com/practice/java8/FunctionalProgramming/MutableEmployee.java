package com.practice.java8.FunctionalProgramming;

public class MutableEmployee {
    private String name;
    private int salary;

    public MutableEmployee(String name,int  salary) {
        this.name = name;
        this.salary = salary;
    }

    //setter modifies the salary - side effect
    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

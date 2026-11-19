package com.practice.java8.Interfaces;

@FunctionalInterface
public interface Foldable{
    static void printFoldInstructions(){
        System.out.println("Foldable");
    }
    default void fold(){
        System.out.println("default method");
    }
    void wash();
}

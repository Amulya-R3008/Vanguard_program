package com.practice.java8.Interfaces;

public class Item implements Foldable{

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void wash(){
        System.out.println("Washing");
    }
    public void fold(){
        System.out.println("folding: "+name);
    }
    public static void main(String[] args) {
     Foldable.printFoldInstructions();

        Item item=new Item("bags");
        item.fold();
        item.wash(); 
    }

}

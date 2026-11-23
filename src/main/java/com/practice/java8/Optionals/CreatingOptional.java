package com.practice.java8.Optionals;

import java.util.Optional;

public class CreatingOptional {
    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.empty();
        System.out.println("optionalUser:"+ optionalUser.isPresent());

        User user=null;
        //Optional<User> optionalUser2 = Optional.of(user);
        //System.out.println("optionalUser2:"+ optionalUser2.isPresent()); //null pointer exception
        Optional<User> optionalUser3 = Optional.ofNullable(user);
        System.out.println("optionalUser3:"+ optionalUser3.isPresent());

        Optional<User> optionalUser1 = Optional.of(new User("Amulya"));
        System.out.println("optionalUser1:"+ optionalUser1.isPresent());
        System.out.println("optionalUser1:"+ optionalUser1.orElseThrow(()->new NullPointerException("no value")));

        System.out.println("null: "+optionalUser3.orElseGet(()->new User("am")));

        System.out.println(optionalUser1.filter(u->u.getName().startsWith("A")).orElse(new User("Aditya")));

        Optional<Integer> integerOptional = Optional.of(10);
        System.out.println("integerOptional:"+ integerOptional.map(i->i*2).get());
    }

}

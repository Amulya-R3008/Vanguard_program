package com.practice.java8.FunctionalProgramming;

import org.springframework.validation.annotation.ValidationAnnotationUtils;

@FunctionalInterface
interface Transformer<T>{
    T transform(T input);

    //default methods are allowed
    default Transformer<T> andThen(Transformer<T> after){
        return input -> after.transform(this.transform(input));
    }

    //static methods are allowed
    static <T> Transformer<T> identity(){
        return  input -> input;
    }
}

@FunctionalInterface
interface TriFunction<A,B,C,R>{
    R apply(A a,B b,C c);
}

@FunctionalInterface
interface Validator<T>{
    ValidationResult validate(T t);

    default Validator<T> and(Validator<T> other){
        return t->{
            ValidationResult result = this.validate(t);
            return result.isValid() ? other.validate(t) : result;
        };
    }
}

class ValidationResult{
    private final boolean valid;
    private final String  message;
    private ValidationResult(boolean valid, String message){
        this.valid = valid;
        this.message = message;
    }

    public static ValidationResult vaild(){
        return new ValidationResult(true,"");
    }

    public  static ValidationResult invalid(String message){
        return new ValidationResult(false, message);
    }
    public  boolean isValid(){
        return this.valid;
    }
    public String getMessage(){return message;}

}
public class CustomFunctionalInterfaceDemo {
    public static void main(String[] args) {

        //Transformer eg
        Transformer<String> trim = String::trim;
        Transformer<String> upper = String::toUpperCase;
        Transformer<String>  trimAndUpper = trim.andThen(upper);

        System.out.println(trimAndUpper.transform(" hello   "));

        //TriFunction eg
        TriFunction<Integer, Integer, Integer, Integer> andThree = (a,b,c)->a+b+c;
        System.out.println(andThree.apply(1,2,3));

        //validator example
        Validator<String> isNotEmpty = s->
                s!= null && !s.isEmpty()
                ? ValidationResult.vaild()
                        : ValidationResult.invalid("Empty String");

        Validator<String> isLongEnough = s ->
                s.length() >= 5
                ? ValidationResult.vaild()
                        : ValidationResult.invalid("Longer String");

        Validator<String> combined = isNotEmpty.and(isLongEnough);

        ValidationResult result = combined.validate("hello");
        System.out.println(result.isValid());
        System.out.println(result.getMessage());


    }
}

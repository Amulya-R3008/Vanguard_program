package com.practice.java8.FunctionalProgramming;

public class LambdaVsAnonymousClass {
    //in lambda: 'this' = the enclosing class instance
    Runnable lambdaThis = ()->{
        //'this' refers to LambdaVsAnonymousClass instance
        System.out.println(this.getClass().getName());
    };

    public static void main(String[] args) {

        //anonymous inner class
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous class");
            }
        };
        // Creates: LambdaVsAnonymousClass$1.class
        // Has its own 'this' reference
        // Can have state (fields)


        //lambda
        Runnable lambdaRunnable = () -> System.out.println("lambda class");
        // NO separate class file
        // 'this' refers to enclosing class
        // Cannot have state

        // this keyword key difference

        //in anonymous class: 'this' = the anonymous class instance
        Runnable anonThis = new Runnable() {
            @Override
            public void run() {
                // 'this' refers to this anonymous runnable instance
                System.out.println(this.getClass().getName());
            }
        };

//        //in lambda: 'this' = the enclosing class instance
//        Runnable lambdaThis = ()->{
//            //'this' refers to LambdaVsAnonymousClass instance
//            System.out.println(this.getClass().getName());
//        };

        anonymousRunnable.run();
        lambdaRunnable.run();

        anonThis.run();
        LambdaVsAnonymousClass l= new LambdaVsAnonymousClass();
        l.lambdaThis.run();

    }
}

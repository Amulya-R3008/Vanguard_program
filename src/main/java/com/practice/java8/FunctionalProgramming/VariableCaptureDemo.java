package com.practice.java8.FunctionalProgramming;

import java.util.function.Consumer;

public class VariableCaptureDemo {
    private int instanceVar=10;
    private static   int staticVar=10;

    public void demonstrateCapture(){
        int localVar = 30; //effectively final
        final int finalVar = 40; //explicitly final

        Consumer<String> lambda = s->{
            //can access instance variables (can even modify)
            System.out.println(instanceVar);
            instanceVar = 100;

            //can access static variables (can even modify)
            System.out.println(staticVar);
            staticVar=200;

            //can access local variables (read only)
            System.out.println(localVar);
            //localVar = 50; //compile error - must be effectively final

            System.out.println(finalVar);
            //finalVar = 30; //compile error - final

        };

        // localVar = 35; // If uncommented, lambda above won't compile
        // because localVar would no longer be "effectively final"

        lambda.accept("test");
    }

    public static void main(String[] args) {
        VariableCaptureDemo demo = new VariableCaptureDemo();
        demo.demonstrateCapture();
    }

    /*
    WHY must local variables be effectively final?

    1. Local variables live on the STACK
    2. Lambda might execute AFTER the method returns
       (e.g., passed to another thread)
    3. By then, the local variable is GONE from stack
    4. Java copies the variable's VALUE into the lambda
    5. If the value could change, the copy would be stale
    6. So Java enforces: once captured, cannot change

    Instance/static variables are on the HEAP, so they
    persist and can be accessed/modified anytime.
    */
}

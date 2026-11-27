package com.practice.java8.FunctionalProgramming;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class MethodReferenceComplete {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("A", "B", "C");

        //type 1 : reference to a static method
        //ClassName :: staticMethodName
        //lambda version
        Function<String, Integer> parseInt1 = s ->  Integer.parseInt(s);
        //method reference version
        Function<String, Integer> parseInt2 = Integer::parseInt;

        System.out.println(parseInt1.apply("123"));
        System.out.println(parseInt2.apply("123"));

        BiFunction<Integer, Integer, Integer> max1 = (a,b) -> Math.max(a,b);
        BiFunction<Integer,Integer,Integer> max2 = Math::max;

        System.out.println(max1.apply(1,2));
        System.out.println(max2.apply(1,2));

        //custom static method
        //lambda : s-> StringUtils.reverse(s)
        //reference: StringUtils::reverse
        Function<String , String> reverser = StringUtils::reverse;
        System.out.println(reverser.apply("hello"));

        //type 2: reference to an instance method of a particular object
        // instance::methodName

        String prefix = "Mr. ";

        //lambda version
        Function<String, String > addPrefix1 = s-> prefix.concat(s);
        //method reference version
        Function<String, String > addPrefix2 = prefix::concat;
        System.out.println(addPrefix1.apply("Hello"));
        System.out.println(addPrefix2.apply("Hello"));

        //System.out is a particular object (printstream instance)
        Consumer<String> printer = System.out::println;
        names.forEach(printer);

        //custom object instance method
        Comparator<String> customComparator = new CaseInsensitiveComparator();
        //lambda : (a,b) -> customComparator.compare(a,b)
        // reference : customComparator::compare
        names.sort(customComparator::compare);

        //type 3: reference to an instance method of an arbitrary object of a particular type
        //ClassName:: insatnceMethodName

        //the first parameter becomes the object on which the method is called

        //lambda : s-> s.toUpperCase()
        //here 's' is the arbitrary string object
        Function<String,String> upper1= s->s.toUpperCase();
        Function<String , String > upper2= String::toUpperCase;

        System.out.println(upper1.apply("Hello"));
        System.out.println(upper2.apply("Hello"));

        //lambda : s-> s.length()
        Function<String,Integer> len1 = s->s.length();
        Function<String ,Integer> len= String::length;
        System.out.println(len1.apply("Hello"));
        System.out.println(len.apply("Hello"));

        //lambda : (s1,s2) -> s1.compareTo(s2)
        //s1 is the arbitrary string, s2 is the parameter
        Comparator<String> comp1 = (s1,s2)->s1.compareTo(s2);
        Comparator<String> comp2 = String::compareTo;

        System.out.println(comp1.compare("hi","hi"));
        System.out.println(comp2.compare("hi","hi"));

        //lambda : s->s.isEmpty()
        Predicate<String > empty1= s->s.isEmpty();
        Predicate<String> empty2 = String::isEmpty;
        System.out.println(empty1.test("hello"));
        System.out.println(empty2.test(""));

        //type 4: reference to a constructor
        //ClassName::new

        //no-arg constructor
        //lambda : ()->new ArrayList()
        Supplier<List<String>> listFactory1 = () -> new ArrayList<>();
        Supplier<List<String>> listFactory2 = ArrayList::new;
        System.out.println(listFactory1.get().add("hi")); // it will print true
        //System.out.println(listFactory1.get()); //it will create empty list

        //single-arg constructor
        //lambda: s-> new stringBuilder()
        Function<String, StringBuilder> sbFactory1 = s->new StringBuilder(s);
        Function<String, StringBuilder> sbFactory2 = StringBuilder::new;
        System.out.println(sbFactory1.apply("hello"));

        //2 -arg constructor
        //lambda : (name,age)->new Person(name,age)
        BiFunction<String , Integer, Person> personFactory1 = (name,age) -> new Person(name,age);
        BiFunction<String, Integer, Person> personFactory2 = Person::new;

        System.out.println(personFactory1.apply("amulya",24));

        //array constructor refernce
        //lambda : n->new String[n]
        Function<Integer,String[]> arrayFactory1 = n->new String[n];
        Function<Integer,String[]> arrayFactory2 = String[]::new;
        System.out.println(Arrays.toString(arrayFactory1.apply(1)));

        //useful with toArray()
        String[] nameArray = names.stream().toArray(String[]::new);



    }
}

class StringUtils{
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();

    }
}

class CaseInsensitiveComparator implements  Comparator<String>{
    public int compare(String a, String b){
        return a.compareTo(b);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
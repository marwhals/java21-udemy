package Java8.Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTypes {
    public static void main(String[] args) {
        boundMethodReferences();        // bound
        unboundMethodReferences();      // unbound
        staticMethodReferences();       // static
        constructorMethodReferences();  // constructor
    }

    public static void boundMethodReferences() {
        String name = "Mr. Joe Bloggs";
        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;
        // No need to say which instance to call it on - the supplier is bound to name
        System.out.println(lowerL.get()); // mr. joe bloggs
        System.out.println(lowerMR.get());// mr. joe bloggs

        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr.")); // true
        System.out.println(titleMR.test("Ms."));// false
    }

    public static void unboundMethodReferences() {
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        // The function is unbound, so you need to specify which instance to call it on
        System.out.println(upperL.apply("marjan"));
        System.out.println(upperMR.apply("marjan"));

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatL.apply("Arnold", "Something"));

        // 1st parameter is used for executing the instance method
        // "Tim ".concat("Timson")
        System.out.println(concatMR.apply("Tim ", "Timson"));
    }

    public static void staticMethodReferences() {
        //  Static method references are considered UNBOUND also. An example static method
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
        sortL.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [1, 2, 4, 5, 9]

        listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [3, 4, 7, 8, 12]
    }

    public static void constructorMethodReferences() {

        Supplier<StringBuilder> sbL = () -> new StringBuilder();  // lambda
        Supplier<StringBuilder> sbMR = StringBuilder::new;         // method reference
        StringBuilder sb1 = sbL.get();
        sb1.append("lambda version");
        System.out.println(sb1);
        StringBuilder sb2 = sbMR.get();
        sb2.append("method reference version");
        System.out.println(sb2);

        Function<Integer, List<String>> alL = x -> new ArrayList(x);
        Function<Integer, List<String>> alMR = ArrayList::new;
        List<String> ls1 = alL.apply(10);  // size 10
        ls1.add("21");
        System.out.println(ls1);//[21]
        List<String> ls2 = alMR.apply(5);  // size 5
        ls2.add("88");
        System.out.println(ls2);//[88]
    }
}
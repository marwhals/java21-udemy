package Java8.Lambdas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {

    String name = "";

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("John");

        int x = 12; // final or effectively final

        Predicate<String> lambda = s -> {
//            x++; not allowed....unless atomic
            new LambdaEffectivelyFinal().name = "Marjan Two"; // this is okay
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };
        filterData(al, lambda);// lambda views 'x' as 12
        System.out.println(al);

        new LambdaEffectivelyFinal().name = "Marjan";

        filterData(al, lambda);// lambda views 'x' as 12

    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            if (lambda.test(i.next())) { // lambda is executed here
                i.remove();
            }
        }
    }
}

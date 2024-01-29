package Java8.CollectionsAndGenerics.basics;

import java.util.Arrays;
import java.util.Collection;

public class CommonCollectionMethods {
    public static void main(String[] args) {
        // Lists allow duplicates
//        Collection<String> coll = new ArrayList<>();

        // asList() returns an unmodifiable collection
        //  => add() throws an UnsupportedOperationException
        Collection<String> coll = Arrays.asList("Lucy", "April", "Lucy");//immutable

        coll.add("Lucy");
        coll.add("April");
        coll.add("Lucy");
        System.out.println(coll);
        System.out.println(coll.remove("Lucy"));
        System.out.println(coll);
        System.out.println(coll.isEmpty());
        System.out.println(coll.size());
        System.out.println(coll.contains("John"));
        System.out.println(coll.contains("Lucy"));
        // removeIf(Predicate) and Predicate == boolean test(T t)
        System.out.println(coll.removeIf(s -> s.startsWith("A")));
        coll.forEach(name -> System.out.println(name));
        coll.clear();
        coll.forEach(System.out::println);

    }

}

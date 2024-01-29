package Java8.CollectionsAndGenerics.basics;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UsingMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(); // sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        System.out.println(map.containsKey("John"));
        System.out.println(map.containsValue(18));
        System.out.println(map.isEmpty());
        System.out.println(map.get("John"));
        for (String name : map.keySet()) {
            System.out.println(name);
        }
        for (Integer age : map.values()) {
            System.out.println(age);
        }
        System.out.println(map.containsKey("Paul"));
        System.out.println(map.containsValue(21));
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());

        // forEach()
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        //   forEach(BiConsumer)
        //     BiConsumer<T,U>     void accept(T t, U u)
        map.forEach((k, v) -> System.out.println(k + " maps to " + v));

        // Set<Map.Entry<K,​V> entrySet() - Map.Entry encapsulates a key-value pair.
        // go from a Map to a Set (an official Collection)
        map.entrySet().forEach(entry ->     //    forEach(Consumer)
                System.out.println(entry.getKey() + " -> " + entry.getValue()));

        Set keys = map.keySet();
        // putIfAbsent()
        map.put("Mike", null);
        map.putIfAbsent("Chris", 99);
        map.putIfAbsent("Mike", 55);
        map.putIfAbsent("Luke", 31);

        // replace() and replaceAll
        Integer original = map.replace("Chris", 81);
        System.out.println(map);
        // BiFunction<T, U, R>
        //   R apply(T t, U u) - 2 inputs and an output; all of which can be different types
        // replaceAll(BiFunction<K, V, V> fn) - note the return type is of type V also
        map.replaceAll((name, age) -> name.length());
        System.out.println(map);

        // remove()
        map.remove("Mike");
    }
}

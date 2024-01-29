package Java8.CollectionsAndGenerics.basics;

import java.util.*;

public class UsingLists {
    public static void main(String[] args) {
        factoryMethods();
        arrayList();
        stack();
        linkedList();
    }

    public static void factoryMethods() {
        String[] array = new String[]{"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array); // 'array' and 'asList' are now 'backed'
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);

        array[0] = "Delta";     // changes to the array 'write through' to the list
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        asList.set(1, "Echo");  // changes to the list 'write through' to the array
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

//        of.add("Foxtrot");                        // UnsupportedOperationException
//        copy.add("Foxtrot");                      // UnsupportedOperationException
//        asList.add("Foxtrot");                    // UnsupportedOperationException
    }

    public static void arrayList() {
        //     = Lists maintain Order (index) and allow Duplicates
        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(0);
        list.remove("Mary");
        System.out.println(list);
        list.set(0, "Jack");
        // replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T,T> where the
        //                                   input and output are the same type
        list.replaceAll(name -> name + " Kennedy");
        System.out.println(list);
    }

    public static void stack() {
        // Stack is a LIFO structure (Last In First Out) - we can manipulate one end only.
        // Using the Stack type as the reference type so we get access to the push(), pop() and peek() methods.
        Stack<String> stack = new Stack<>();// legacy class, use Deque interface instead
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.push("Helen");
        System.out.println(stack);
    }

    public static void linkedList() {
        // A doubly-linked list. We can manipulate both ends.
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin");
        names.add("David");
        names.addFirst("Brian");
        names.addLast("Edward");
        System.out.println(names);

        names.remove("David");
        names.removeFirst();
        names.removeLast();
        System.out.println(names);

    }
}

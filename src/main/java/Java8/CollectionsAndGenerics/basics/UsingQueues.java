package Java8.CollectionsAndGenerics.basics;

import java.util.*;

class Book {
    private String title;
    private Double price;

    Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

public class UsingQueues {
    public static void main(String[] args) {
        linkedListQueue();
        arrayDeque();
        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    public static void linkedListQueue() {
        // A FIFO queue
        Queue<Integer> queue = new LinkedList<>();
        // add() inserts into queue (throws exception if no space exists - if capacity restricted)
        // offer() inserts into queue (returns false if no space exists - capacity restricted)
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.offer(4);
        // element() retrieves but does not remove the head of the queue (throws exception if queue empty)
        // peek() retrieves but does not remove the head of the queue (returns null if queue empty)
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue);
        // remove() - Retrieves and removes the head of this queue (throws exception if queue empty)
        // poll() - Retrieves and removes the head of this queue (returns null if this queue is empty)
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);

        // offer()/poll() and peek() are the preferred methods as they do not throw exceptions

    }

    public static void arrayDeque() {
        // Deque = "doubly ended queue". Supports element insertion/removal at both ends.
        // ArrayDeque - resizeable-array implementation of the Deque interface (no capacity restrictions).
        Deque<Integer> numbers = new ArrayDeque<>();
        // "arg" (as in main(String []ARGs)
        // Deque methods that begin with "a", "r" or "g" e.g. addFirst(), addLast(),
        // removeFirst(), removeLast(), getFirst() and getLast() all throw exceptions if
        // the deque is both capacity-constrained and full.
        // The other methods : peekFirst(), peekLast(), offerFirst(), offerLast(), pollFirst(), pollLast;
        // rather than throw an exception in the same situation, they return null/false.
        // add at front (the head)
        numbers.add(1);
        numbers.addFirst(2);     //   - exception thrown if deque is full
        numbers.offerFirst(3); //   - null/false if deque is full
        System.out.println("Head: " + numbers.getFirst() + ". Head: " + numbers.peekFirst());

        numbers.addLast(4);
        numbers.offerLast(5);
        // remove from both ends
        numbers.removeFirst();
        numbers.pollFirst();
        numbers.removeLast();
        numbers.pollLast();
        System.out.println(numbers);


        System.out.println(numbers.offer(11));
        System.out.println(numbers.offer(12));
        System.out.println(numbers.peek());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
    }

    public static void priorityQueueNaturalOrdering() {

        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.add("P");
        names.add("A");
        Iterator itNames = names.iterator();
        while (itNames.hasNext()) {
            System.out.print(names.poll() + " ");
        }

        Queue<Integer> numbers = new PriorityQueue<>();// numeric ordering
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);
        Iterator itNumbers = numbers.iterator();
        while (itNumbers.hasNext()) {
            System.out.print(numbers.poll() + " ");
        }
    }

    public static void priorityQueueDifferentOrdering() {
        // Ordering specified by a comparator at construction time

        // 1. Order by the title of the book
        // Comparator.comparing(Function)
        //   API: "Accepts a function that extracts a Comparable sort key from a type T, 
        //        and returns a Comparator<T> that compares by that sort key."
        //   Function<T, R>
        //      R apply(T t)
        Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());
//        Comparator<Book> comparatorTitle = Comparator.comparing(Book::getTitle);
        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);// order by title
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title:");
        Iterator itBooks = booksByTitle.iterator();
        while (itBooks.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);

        }

        // 2. Order by the price of the book
        Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
        Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
        booksByPrice.add(new Book("Java", 55.0));
        booksByPrice.add(new Book("Python", 23.0));
        booksByPrice.add(new Book("C++", 99.0));

        System.out.println("Ordering by price:");
        Iterator itMoreBooks = booksByPrice.iterator();
        while (itMoreBooks.hasNext()) {
            Book book = booksByPrice.poll();
            System.out.println(book);

        }
    }

}

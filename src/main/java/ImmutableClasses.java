
public final class Person {
    // instance fields are final and private - can only be assigned once
    private final String name; //blank finals
    private final int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

void main() {
    Person p1 = new Person("Joe bloggs", 23);
    System.out.println(p1);
    Person p2 = new Person("Mary Blooooogs", 42);
    System.out.println(p2);
    p1 = new Person("Steve blogggggsszz", 10023); //Reference is mutable though
    System.out.println();
}
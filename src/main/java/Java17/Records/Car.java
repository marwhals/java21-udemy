package Java17.Records;

import java.util.Objects;

public class Car {
    private final String regNumber;
    private final String owner;



    public String getRegNumber() {
        return regNumber;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return STR."Car{regNumber='\{regNumber}\{'\''}, owner='\{owner}\{'\''}\{'}'}"; //Java 21
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, owner);
    }

    public Car(String regNumber, String owner) {
        this.regNumber = regNumber;
        this.owner = owner;
    }
}

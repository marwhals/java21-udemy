package Java17.SealedClasses;

sealed interface Driveable permits Vehicle {

}

public sealed class Vehicle implements Driveable permits Car {
}

sealed class Car extends Vehicle permits Ford, Volvo{}

final class Ford extends Car{}

final class Volvo extends Car{}

//class Table extends Vehicle{} -- if has not been permitted you will get a compiler error

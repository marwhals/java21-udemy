package Java17.Records;

public class CarMain {

    public static void main(String[] args) {
        Car car = new Car("123ABC22", "Stevie Wonder");
        System.out.println(car);
        System.out.println(car.getOwner());
        System.out.println(car.getRegNumber());

        CarRecord carRecord = new CarRecord("12345678", "Stevie Nicks");
        System.out.println(carRecord);
        System.out.println(carRecord.owner());
        System.out.println(carRecord.regNumber());

        // 3. Define an instance method; cannot define an instance field
        System.out.println(carRecord.isNewCar());

        // 4. Define a static field
        System.out.println(CarRecord.currentYear);

        // 5. Define a static method
        CarRecord blankCar = CarRecord.createBlankCarRecord();
        System.out.println("blank owner:"+blankCar.owner()); // slightly different accessor method names
        System.out.println("blank reg number:"+blankCar.regNumber());
            }

}

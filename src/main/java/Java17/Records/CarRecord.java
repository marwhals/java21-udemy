package Java17.Records;

//No extends clause allowed for record
public record CarRecord(String regNumber, String owner) implements I {
    //  private final int age; // instance fields must be listed in constructor signatiure above
    public static final String currentYear = "23";

    // custom canonical constructor
    public CarRecord(String regNumber, String owner) {
        if (regNumber.length() <= 4) {
            System.out.println("spooky " + regNumber + " spooky");
            throw new IllegalArgumentException();
        }
        this.regNumber = regNumber;
        this.owner = owner;
    }
    // compact constructor - specific to records
//    public CarRecord  {
//        if(regNumber.length() <= 4){
//            throw new IllegalArgumentException();
//        }
//    }

    public CarRecord() {
        this("     ", "");
    }

    public boolean isNewCar() {
        return regNumber().substring(0, 2).equals(currentYear);
    }

    public static CarRecord createBlankCarRecord() {
        return new CarRecord("        ", "");
    }

    @Override
    public String owner() {
        return owner.toUpperCase();
    }

}

// 9. Cannot define a subtype based on a record
//class X extends CarRecord{}  // records are final by default (cannot define a subtype)
interface I{}
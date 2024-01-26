package Java17.SwitchExpressionsNPatternMatching;

public class PatternMatching {
    public static void whatType(Object o){
        switch(o){
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognised");
        }
    }
    public static void infoOnType(Object o){
        switch(o){
//            case String s && s.startsWith("A")-> System.out.println("String beginning with A : "+s); // Guarded pattern will need a refactor
//            case Integer i && i.intValue() > 10 -> System.out.println("Integer > 10 : "+i);
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognised");
        }
    }

    public static void main(String[] args) {
        whatType("ABC");
        whatType(122);
        whatType(null);
        whatType(32.39);// Double

        infoOnType("ABC");
        infoOnType("abc");
        infoOnType(12);
        infoOnType(8);
    }
}

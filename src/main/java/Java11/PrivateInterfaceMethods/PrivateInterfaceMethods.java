package Java11.PrivateInterfaceMethods;

/*
Why 'private' interface methods
1) reduce code duplication
2) Improves encapsualtion by hiding implementation details
 */

interface InefficientTennis {
    static void forehand() {
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into ready position");
    }

    default void backhand() {
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back into ready position");
    }

    default void smash() {
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back into ready position");
    }
}
//Note: If 'hit' is simply 'private' and not 'private static' then 'forehand()' has an issue
// This is the same with classes - instance to static is ok but not the other way round

interface Tennis {
    private static void hit(String stroke) {
        System.out.println("Move into position");
        System.out.println("Hitting a " + stroke);
        System.out.println("Move back into ready position");
    }

    static void forehand() {
        hit("forehand");
    }

    default void backhand() {
        hit("backhand");
    }

    private void smash() {
        hit("smash");
    }

//    void volley() {hit("forehand");} abstract methods cannot have a method body
}

class ProffesionalTennis implements Tennis {
    public static void main(String[] args) {
        /*
        - The hit() method is hidden/inaccesible - the undelying implementation is hidden from the user
         */
        Tennis tennis = new ProffesionalTennis();
        tennis.backhand();
        Tennis.forehand();
    }
}
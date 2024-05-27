package literatur;

public class B363 {
    public static void main(String[] args) {
        int age = 10;

        // (a) doable
        if (age < 16)
            System.out.println("Cannot get a driver's license");
        if (age >= 16)
            System.out.println("Can get a driver's license");

        // (b) best
        if (age < 16)
            System.out.println("Cannot get a driver's license");
        else
            System.out.println("Can get a driver's license");
    }
}

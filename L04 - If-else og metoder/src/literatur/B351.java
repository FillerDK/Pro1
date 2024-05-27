package literatur;

public class B351 {
    public static void main(String[] args) {
        int x = 2;
        int y = 2;

        if (x > 2) {
            if (y > 2) {
                int z = x + y;
                System.out.println("z is " + z);
            }
        } else {
            System.out.println("x is " + x);
        }
        // x = 3, y = 2
        // no output

        // x = 3, y = 4
        // output: "z is 7"

        // x = 2, y = 2
        // output: "x is 2"
    }
}

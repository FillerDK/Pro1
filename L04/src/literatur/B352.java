package literatur;

public class B352 {
    public static void main(String[] args) {
        int x = 3;
        int y = 3;

        if (x > 2) {
            if (y > 2) {
                int z = x + y;
                System.out.println("z is " + z);
            }
        } else {
            System.out.println("x is " + x);
        }
        // x = 2, y = 3
        // output: "x is 2:

        // x = 3, y = 2
        // no output

        // x = 3, y = 3
        // output: "z is 6"
    }
}

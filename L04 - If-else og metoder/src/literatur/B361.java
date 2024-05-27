package literatur;

public class B361 {
    public static void main(String[] args) {
        int i = 1;
        int j = 0;
        int x = 1;
        int k = 1;
        int y = 1;
        int z = 1;

        // (a) wrong
        if (i > 0) if
        (j > 0)
        x = 0; else
        if (k > 0) y = 0;
        else z = 0;

        System.out.println("a. x is " + x + ", y is " + y + ", z is " + z);

        // (b) correct
        if (i > 0) {
            if (j > 0)
                x = 0;
            else if (k > 0)
                y = 0;
        }
        else
            z = 0;

        System.out.println("b. x is " + x + ", y is " + y + ", z is " + z);

        // (c) correct
        if (i > 0)
            if (j > 0)
                 x = 0;
                else if (k > 0)
                    y = 0;
                else
                    z = 0;

        System.out.println("c. x is " + x + ", y is " + y + ", z is " + z);

        // (d) correct
        if (i > 0)
            if (j > 0)
                x = 0;
            else if (k > 0)
                y = 0;
        else
            z = 0;

        System.out.println("d. x is " + x + ", y is " + y + ", z is " + z);
    }
}

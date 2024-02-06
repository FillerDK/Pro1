package literatur;

public class B364 {
    public static void main(String[] args) {
        int number = 30;

        // (a)
        if (number % 2 == 0)
            System.out.println(number + " is even");
        if (number % 5 == 0)
            System.out.println(number + " is multiple of 5");
        // output for 14, 15 and 30
        // 14: "14 is even"
        // 15: "15 is multiple of 5"
        // 30: "30 is even"
        //     "30 is multiple of 5"

        // (b)
        if (number % 2 == 0)
            System.out.println(number + " is even");
        else if (number % 5 == 0)
            System.out.println(number + " is multiple of 5");

        // output for 14, 15 and 30
        // 14: "14 is even"
        // 15: "15 is multiple of 5"
        // 30: "30 is even"
    }
}

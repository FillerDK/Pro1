package classEx;

import java.util.Scanner;

public class B22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Write the length of a side: ");
        double sideLength = scan.nextDouble();

        double area = (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
        double volume = area * sideLength;

        System.out.println("Area is " + area);
        System.out.println("Volume is " + volume);
    }
}

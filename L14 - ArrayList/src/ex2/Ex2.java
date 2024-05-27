package ex2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);

        // Test of sum() method: correct sum is 61.
        System.out.println("Sum: " + sum(ints));

        // Test of minimum() method: correct minimum is -16.
        System.out.println("Minimum: " + minimum(ints));

        // Test of maximum() method: correct maximum is 45.
        System.out.println("Maximum: " + maximum(ints));

        // Test of average() method: correct average is 7.625.
        System.out.println("Average: " + average(ints));

        // Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Zeroes: " + zeroes(ints));

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println(evens(ints));
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    // sum made with for-each loop
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int value : list) {
            sum += value;
        }
        return sum;
    }

    // minimum found with for-each loop
    public static int minimum(ArrayList<Integer> list) {
        int minimum = list.get(0);
        for (int value : list) {
            if (value < minimum)
                minimum = value;
        }
        return minimum;
    }

    // maximum found with for-each loop
    public static int maximum(ArrayList<Integer> list) {
        if (list.size() != 0) {
            int maximum = -999999;
            for (int value : list) {
                if (value > maximum)
                    maximum = value;
            }
            return maximum;
        } else return 0;
    }

    // average found with for-each loop
    public static double average(ArrayList<Integer> list) {
        int sum = 0;
        for (int value : list) {
            sum += value;
        }
        double average = 1.0 * sum / list.size();
        return average;
    }

    // amount of zeroes found with for-each loop
    public static int zeroes(ArrayList<Integer> list) {
        int zeroes = 0;
        for (int value : list) {
            if (value == 0) zeroes++;
        } return zeroes;
    }

    // evens found with for-each loop
    public static ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (int value : list)
            if (value % 2 == 0) evens.add(value);
        return evens;
    }
}

package ex5.B1113;

import java.util.ArrayList;
import java.util.Scanner;

public class DuploBeGone {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();

        System.out.print("Enter 10 integers seperated by a space: ");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int numbers = input.nextInt();
            ints.add(numbers);
        }
        removeDuplicate(ints);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        System.out.print("The distinct integers are: ");
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int value : list) {
                if (list.get(i) == value) {
                    count++;
                }
            }
            System.out.print(list.get(i) + " ");
        }
    }
}

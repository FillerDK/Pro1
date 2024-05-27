package ex4;

import java.util.ArrayList;

public class Ex4Test {
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

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(0);
        integers.add(11);
        integers.add(10);

        System.out.println(ints);
        //switchFirstAndLast(ints);
        System.out.println(ints);

        //replaceEvenWithZero(ints);
        System.out.println(ints);

        System.out.println(secondHighestElement(ints));

        System.out.println(isSortedAscending(integers));

        shiftAllElementsRight(ints);
        System.out.println(ints);

        System.out.println(hasDoublets(ints));
    }

    public static void switchFirstAndLast(ArrayList<Integer> list) {
        if (list.size() >= 1) {
            int temp = list.getFirst();
            list.set(0, list.getLast());
            list.set(list.size() - 1, temp);
        }
    }

    public static void replaceEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                list.set(i, 0);
        }
    }

    public static int secondHighestElement(ArrayList<Integer> list) {
        int highest = list.getFirst();
        int secondHighest = 0;
        if (list.size() >= 2) {
            for (int value : list) {
                if (value > highest)
                    highest = value;
            }
            for (int value : list) {
                if (value > secondHighest && value < highest)
                    secondHighest = value;
            }
        }
        return secondHighest;
    }

    public static boolean isSortedAscending(ArrayList<Integer> list) {
        boolean ascending = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i))
                return ascending = false;
        }
        return ascending;
    }

    public static void shiftAllElementsRight(ArrayList<Integer> list) {
        if (list.size() >= 1) {
            list.addFirst(list.getLast());
            list.removeLast();
            // list.addFirst(list.remove(list.size() - 1);
        }
    }

    public static boolean hasDoublets(ArrayList<Integer> list) {
        // while and for statements with nested return = ugly programming

        // for (int value : list) {
        //      if (list.indexOf(value) != list.indexOf(value)) return true
        // } return false

        if (list.size() < 2) return false;

        boolean hasDoublets = false;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++)
                if (list.get(i) == list.get(j))
                    count++;
            if (count >= 2)
                return hasDoublets = true;
            count = 0;
        }
        return hasDoublets;
    }
}

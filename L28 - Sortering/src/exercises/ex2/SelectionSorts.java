package exercises.ex2;

import demosorting.App;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSorts {
    public static void main(String[] args) {
        // -----------------ArrayList--------------------
        /*String[] names = {"Per", "Hans", "Ib", "Jens", "Pia", "Ulla", "Per", "Hans", "Per", "Pia", "Mike", "Ea"};

        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(names));
        System.out.println();

        selectionSort(names);
        System.out.println("Sorted with insertion sort:");
        System.out.println(Arrays.toString(names));
        System.out.println();

        Arrays.sort(names);
        System.out.println("Sorted with Arrays.sort():");
        System.out.println(Arrays.toString(names));
        System.out.println();*/

        // -----------------ArrayList--------------------
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Per", 11));
        customers.add(new Customer("Hans", 3));
        customers.add(new Customer("Ib", 2));
        customers.add(new Customer("Jens", 5));
        customers.add(new Customer("Pia", 17));
        customers.add(new Customer("Ulla", 9));
        customers.add(new Customer("Per", 30));
        customers.add(new Customer("Hans", 15));
        customers.add(new Customer("Per", 2));
        customers.add(new Customer("Pia", 4));
        customers.add(new Customer("Mike", 11));
        customers.add(new Customer("Ea", 10));

        System.out.println("Unsorted:");
        System.out.println(customers);
        System.out.println();

        listSelectionSort(customers);
        System.out.println("Sorted with insertion sort:");
        System.out.println(customers);
        System.out.println();
    }

    private static void selectionSort(String[] arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {
            // find the index of the smallest number in unsorted part
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            // swap arr[indexOfMin] and arr[i]
            if (indexOfMin != i) {
                String temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    private static void listSelectionSort(ArrayList<Customer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Customer temp = list.get(i);
                list.set(i, list.get(indexOfMin));
                list.set(indexOfMin, temp);
            }
        }
    }
}

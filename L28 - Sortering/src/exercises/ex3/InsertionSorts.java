package exercises.ex3;

import demosorting.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSorts {
    public static void main(String[] args) {
        // -----------------ArrayList--------------------
        String[] names = {"Per", "Hans", "Ib", "Jens", "Pia", "Ulla", "Per", "Hans", "Per", "Pia", "Mike", "Ea"};

        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(names));
        System.out.println();

        insertionSort(names);
        System.out.println("Sorted with insertion sort:");
        System.out.println(Arrays.toString(names));
        System.out.println();

        Arrays.sort(names);
        System.out.println("Sorted with Arrays.sort():");
        System.out.println(Arrays.toString(names));
        System.out.println();

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

        insertionSort(customers);
        System.out.println("Sorted with insertion sort:");
        System.out.println(customers);
        System.out.println();
    }

    private static void insertionSort(String[] arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            // move values larger than temp in the sorted part up one position;
            // this will create a free position for temp
            int j = i;
            while (j > 0 && temp.compareTo(arr[j-1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            // insert temp at the free position
            arr[j] = temp;
        }
    }

    //---------------------------------------------------------------------

    private static void insertionSort(ArrayList<Customer> list) {
        // list has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 1; i < list.size(); i++) {
            Customer temp = list.get(i);
            // move values larger than list.get(i) in the sorted part up one position;
            // this will create an empty position for list.get(i)
            int j = i;
            while (j > 0 && temp.compareTo(list.get(j-1)) < 0) {
                list.set(j, list.get(j-1));
                j--;
            }
            // insert list.get(i) at the empty position
            list.set(j, temp);
        }
    }
}

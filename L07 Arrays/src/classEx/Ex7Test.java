package classEx;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Ex7Test {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 6};
        //swapFirstAndLastInArray(array);
        //System.out.println(Arrays.toString(evenToZero(array)));
        //System.out.println("The second highest number is: " + secondHighestInArray(array));
        //System.out.println("The array is sorted in ascending order: " + arraySortedAscending(array));
        //System.out.println(Arrays.toString(reverse(array)));
        //System.out.println("The array has doublets: " + hasDoublets(array));
    }

    public static void swapFirstAndLastInArray(int[] array) {
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
        System.out.println(Arrays.toString(array));
    }

    public static int[] evenToZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) array[i] = 0;
        }
        return array;
    }

    public static int secondHighestInArray(int[] array) {
        int almostMax = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] < max && array[i] > almostMax) {
                almostMax = array[i];
            }
        }
        return almostMax;
    }

    public static boolean arraySortedAscending(int[] array) {
        int previous = array[0];
        boolean sorted;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= previous) {
                sorted = true;
            } else return false;
        }
        return true;
    }

    public static int[] reverse(int[] list) {
        int[] reverseList = new int[list.length];
        int temp = list[list.length - 1];

        for (int i = 0; i < reverseList.length - 1; i++) {
            reverseList[i + 1] = list[i];
        }
        reverseList[0] = temp;
        return reverseList;
    }

    public static boolean hasDoublets(int[] a) {
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }

        int[] b = new int[max + 1];

        for (int i = 0; i < a.length; i++) b[a[i]]++;

        for (int i = 0; i < b.length; i++) {
            if (b[i] > 1) return true;
        }


        return false;
    }
}

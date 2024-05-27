package classEx;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] t = {4, 6, 7, 2, 3};
        int[] s = {4, 6, 8, 2, 6, 4};
        System.out.println("The sum of all integers in the array t is: " + sum(t));
        System.out.println("The sum of array t + array s is: " + Arrays.toString(sumArrays(t, s)));
        System.out.println("The array t has an uneven number in it: " + hasUneven(t));
    }

    public static int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum = sum + t[i];
        }
        return sum;
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int[] sumArrays;
        if (a.length > b.length) {
            sumArrays = new int[a.length];
            for (int i = 0; i < b.length; i++) {
                sumArrays[i] = a[i] + b[i];
            }
            for (int i = b.length; i < a.length; i++) {
                sumArrays[i] = a[i];
            }
        }else if (b.length > a.length) {
            sumArrays = new int[b.length];
            for (int i = 0; i < a.length; i++) {
                sumArrays[i] = a[i] + b[i];
            }
            for (int i = a.length; i < b.length; i++) {
                sumArrays[i] = b[i];
            }
        } else {
            sumArrays = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                sumArrays[i] = a[i] + b[i];
            }
        }
        return sumArrays;
    }

    public static boolean hasUneven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 != 0) return true;
        }
        return false;
    }
}

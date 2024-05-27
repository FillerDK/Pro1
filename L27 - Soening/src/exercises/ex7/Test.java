package exercises.ex7;

import java.net.SocketTimeoutException;

public class Test {
    public static void main(String[] args) {
        int[] t1 = {4, 3, 12, 5, 7, -4, 1, 8, 12};
        System.out.println(searchSum(t1, 9));
    }

    private static int searchSum(int[] t, int total) {
        int i = 1;
        while (i < t.length) {
            if (match(t, total, i))
                return i;
            i++;
        }
        return -1;
    }

    private static boolean match(int[] t, int total, int i) {
        int sum = 0;
        int j = i;
        while (j < t.length) {
            if (sum == total)
                return true;
            sum += t[j];
            j++;
        }
        return false;
    }
}

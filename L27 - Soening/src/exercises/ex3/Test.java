package exercises.ex3;

public class Test {
    public static void main(String[] args) {
        int[] array1 = {7, 9, 13, 7, 9, 13};
        int[] array2 = {7, 9, 13, 13, 13, 13,7};

        System.out.println(adjacentNumsNTimesAdvanced(array1, 2));
        System.out.println(adjacentNumsNTimesAdvanced(array2, 4));
    }

    private static boolean adjacentNums(int[] arr) {
        boolean adjacentNums = false;
        int i = 1;

        while (!adjacentNums && i < arr.length) {
            if (arr[i-1] == arr[i])
                adjacentNums = true;
            else i++;
        }

        return adjacentNums;
    }

    /** n > 1 */
    private static boolean adjacentNumsNTimes(int[] arr, int n) {
        boolean adjacentNumsNTimes = false;
        int i = 1;
        int count = 1;

        while (!adjacentNumsNTimes && i < arr.length) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == n)
                adjacentNumsNTimes = true;
            else i++;
        }

        return adjacentNumsNTimes;
    }

    private static boolean adjacentNumsNTimesAdvanced(int[] arr, int n) {
        boolean found = false;
        int i = 1;

        while (!found && i < arr.length - (n-1)) {
            boolean matchFound = nSame(arr, n, i);
            if (matchFound) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    private static boolean nSame(int[] arr, int n, int i) {
        boolean foundDiff = false;
        int j = 0;

        while (!foundDiff && j < n) {
            int k = arr[i+j];
            if (k != arr[i]) {
                foundDiff = true;
            } else {
                j++;
            }
        }

        return !foundDiff;
    }
}

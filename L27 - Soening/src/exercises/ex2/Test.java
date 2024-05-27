package exercises.ex2;

public class Test {
    public static void main(String[] args) {
        int[] array = {7, 56, 34, 3, 7, 14, 13, 4};

        System.out.println(in10to15(array));
    }

    /** If array not containing a num in
     * interval [10; 15]
     * @param arr
     * @return
     */
    private static int in10to15(int[] arr) {
        int num = -1;
        int i = 0;

        while (num == -1 && i < arr.length) {
            if (9 < arr[i] && arr[i] < 16) {
                num = arr[i];
            } else {
                i++;
            }
        }

        return num;
    }
}

package exercises.ex1;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 8};
        int[] array2 = {0, 2, 4, 6};

        System.out.println(unevenNumExists(array));
        System.out.println(unevenNumExists(array2));
    }

    private static boolean unevenNumExists(int[] arr) {
        boolean found = false;
        int i = 0;

        while (!found && i < arr.length) {
            if (arr[i] % 2 == 1) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }
}

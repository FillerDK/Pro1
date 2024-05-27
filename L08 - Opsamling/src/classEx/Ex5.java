package classEx;

public class Ex5 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 3, 4, 5};

        System.out.println("The two arrays are in order and have the same values: " + equals(array1, array2));
        System.out.println("The two arrays have the same values in any order, dublicates ignored: " + sameValues(array1, array2));
    }

    public static boolean equals (int[] a, int[] b) {
        boolean equals = false;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                if (a[i] == b[i]) equals = true;
            else equals = false;
        }
        return equals;
    }

    public static boolean sameValues (int[] a, int[] b) {
        for (int e : a) {
            if (!contains(b, e))
                return false;
        }
        for (int e : b) {
            if (!contains(a, e))
                return false;
        }
        return true;
    }

    public static boolean contains (int[] array, int value) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                contains = true;
            }
        }
        return contains;
    }
}

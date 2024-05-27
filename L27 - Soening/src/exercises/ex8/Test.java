package exercises.ex8;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(6);
        ints.add(4);
        ints.add(8);
        ints.add(13);
        ints.add(7);

        System.out.println(swapPlace(ints, 13));
    }

    private static int swapPlace(ArrayList<Integer> list, int target) {
        boolean swapped = false;
        int swapIndex = -1;
        int i = 0;

        while (!swapped && i < list.size()) {
            if (list.get(i) == target) {
                if (i == 0) {
                    swapIndex = 0;
                } else {
                    swapIndex = i-1;
                    list.add(swapIndex, list.remove(i));
                }
                swapped = true;
            } else {
                i++;
            }
        }
        return swapIndex;
    }
}

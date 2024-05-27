package exercises.ex1;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hej");
        strings.add("med");
        strings.add("dig");
        strings.add("dette");
        strings.add("er");
        strings.add("en");
        strings.add("test");

        System.out.println(strings);

        bubbleSort(strings);

        System.out.println(strings);
    }

    private static void bubbleSort(ArrayList<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}

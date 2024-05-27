package exercises.ex5;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hi");
        strings.add("hi");
        strings.add("");
        strings.add("hi");
        strings.add("hi");

        System.out.println(findAllIndices(strings, "hi"));
    }

    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target) {
        ArrayList<Integer> allIndices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                allIndices.add(i);
            }
        }

        return allIndices;
    }
}

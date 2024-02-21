package classEx;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int[] dieTosses = new int[20];
        for (int i = 0; i < dieTosses.length; i++) {
            dieTosses[i] = (int)(Math.random() * 6 + 1);
        }

        boolean inRun = false;
        int precedingNum = dieTosses[0];
        System.out.print(precedingNum);
        for (int i = 1; i < dieTosses.length; i++) {
            if (inRun) {
                if (dieTosses[i] != precedingNum) {
                    System.out.print(")");
                    inRun = false;
                }
            }
            if (!inRun) {
                if (i < dieTosses.length - 1) {
                    if (i != precedingNum && dieTosses[i] == dieTosses[i + 1]) {
                        System.out.print("(");
                        inRun = true;
                    }
                }
            }
            System.out.print(dieTosses[i]);
            precedingNum = dieTosses[i];
        }
        if (inRun) {
            System.out.print(")");
        }
    }
}

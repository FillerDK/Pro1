package classEx;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int size2 = 10;
        int[] rndOrder = new int[10];

        for (int i = 0, k = numbers.length - 1; i < 10; i++) {
            int rndNumber = (int)(Math.random() * (size2));
            rndOrder[i] = numbers[rndNumber];
            numbers[rndNumber] = 0;
            for (int j = rndNumber; j < rndOrder.length; j++) {
                if (j != rndOrder.length - 1) {
                        numbers[j] = numbers[j + 1];
                }
            }
            numbers[k] = 0;
            size2--;
        }
        System.out.println(Arrays.toString(rndOrder));
    }
}

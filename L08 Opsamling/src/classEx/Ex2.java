package classEx;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int size2 = 10;
        int[] rndOrder = new int[10];
        int size1 = 0;

        for (int i = 0; i < 10; i++) {
            int rndNumber = (int)(Math.random() * (size2));
            rndOrder[i] = numbers[rndNumber];
            numbers[rndNumber] = 0;
            for (int j = rndNumber; j < size2 - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[size2 - 1] = 0;
            size1++;
            size2--;
        }
        System.out.println(Arrays.toString(rndOrder));
    }
}

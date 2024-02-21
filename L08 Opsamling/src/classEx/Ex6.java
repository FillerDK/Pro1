package classEx;

import java.awt.desktop.OpenFilesEvent;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];

        S1(lockers);
        openLockers(lockers);
    }

    public static void S1 (boolean[] lockers) {
        for (int i = 0; i < lockers.length; i++) {
            for (int j = i; j < lockers.length; j += i + 1) {
                if (lockers[j] == true) lockers[j] = false;
                else lockers[j] = true;
            }
        }
        System.out.println(Arrays.toString(lockers));
    }

    public static void openLockers (boolean[] lockers) {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}

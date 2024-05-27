package classEx;

import java.sql.SQLOutput;

public class Ex4 {
    public static void main(String[] args) {
        exA(10);
        System.out.println();

        exB(10);
        System.out.println();

        exC(10);
        System.out.println();

        exD(39);
        System.out.println();
    }

    public static void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            int starCount = rowCount - row + 1;
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // go to next line
            System.out.println();
        }
    }

    public static void exB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            int dashCount = rowCount - row;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // print dashes
            int starCount = rowCount - dashCount;
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            // go to next line
            System.out.println();
        }
    }

    public static void exC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

            int starCount = rowCount - row + 1;
            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }

            // print stars
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            // go to next line
            System.out.println();
        }
    }

    public static void exD(int rowCount) {

        for (int row = 1; row <= rowCount; row++) {
            // Print row number
            System.out.printf("%2d: ", row);

            // Column count has to be an odd number.
            // The diamond doesn't have a center if even.
            // E.g. the illustration has 9 columns and 10 rows.
            int colCount = rowCount;
            if (rowCount % 2 == 0) colCount = rowCount - 1;

            // Count number of starts
            int starCount;
            if (row <= rowCount / 2) // first half of rows
                starCount = 2 * row - 1;
            else // last half of rows
                starCount = (2 * rowCount + 1) - 2 * row;

            // Count number of dashes
            int dashCount = colCount - starCount;

            // Print left dashes
            for (int i = 1; i <= dashCount/2; i++)
                System.out.print(' ');
            // Print stars
            for (int i = 1; i <= starCount; i++)
                System.out.print('*');
            // Print right dashes
            for (int i = 1; i <= dashCount/2; i++)
                System.out.print(' ');

            // go to next line
            System.out.println();
        }
    }
}

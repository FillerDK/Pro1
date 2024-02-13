package classEx;

public class Ex4 {
    public static void main(String[] args) {
        exA(10);
        System.out.println();

        exB(10);
        System.out.println();

        exC(10);
        System.out.println();

        exD(10);
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
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            int dashCount = (rowCount - row - 1) / 2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // print dashes
            int starCount = rowCount - dashCount - 5;
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print('-');
            }
            // go to next line
            System.out.println();
        }
    }
}

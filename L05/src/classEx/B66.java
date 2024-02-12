package classEx;

public class B66 {
    public static void main(String[] args) {
        displayPatternRight(20);
    }

    public static void displayPatternLeft(int n) {
        int row = 1;
        while (row <= n) {
            int col = 1;
            while (col <= row) {
                System.out.print(col + " ");
                col++;
            }
            System.out.println();
            row++;
        }
    }

    public static void displayPatternRight(int n) {
        int row = 1;
        while (row <= n) {
            int col = 1;
            while (col <= n) {
                if (col <= n - row) {
                    System.out.print("    ");
                } else if (col - (n - row) < 10) {
                    System.out.print(col - (n - row) + "   ");
                } else {
                    System.out.print(col - (n - row) + "  ");
                }
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
package exercises.ex9;

public class Test {
    public static void main(String[] args) {
        System.out.println(biggestWholeNum(10));
    }

    /** n > 0 */
    private static int biggestWholeNum(int n) {
        for (int r = 0; r <= n; r++) {
            if (r*r <= n && n < Math.pow(r+1, 2)) {
                return r;
            }
        }
        return 0;
    }
}

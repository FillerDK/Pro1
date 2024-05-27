package exercises.ex6;

public class Test {
    public static void main(String[] args) {
        System.out.println(repeatedCharsAdvanced("vnhstxxxaby", 3));
        System.out.println(repeatedCharsAdvanced("vnhstxxxaby", 4));
    }

    /** k >= 0 */
    private static boolean repeatedChars(String s, int k) {
        boolean repeated = false;
        int i = 1;
        int count = 1;

        while (!repeated && i < s.length()) {
            if (s.charAt(i-1) == s.charAt(i)) {
                count++;
            } else {
                count = 1;
            }

            if (count == k)
                repeated = true;
            else i++;
        }

        return repeated;
    }

    private static boolean repeatedCharsAdvanced(String s, int n) {
        int i = 0;
        while (i < s.length() - (n - 1)) {
            if (match(s, n, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean match(String s, int n, int i) {
        boolean foundDiff = false;
        int j = 0;
        while (!foundDiff && j < n) {
            char k = s.charAt(i + j);
            if (k != s.charAt(i)) {
                foundDiff = true;
            } else {
                j++;
            }
        }
        return !foundDiff;
    }
}

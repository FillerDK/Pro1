package classEx;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int[] a = new int[10];
        System.out.print("(a) ");
        System.out.println(Arrays.toString(a));

        int[] b = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        System.out.print("(b) ");
        System.out.println(Arrays.toString(b));

        int[] c = new int[10];
        System.out.print("(c) ");
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }
        System.out.print(Arrays.toString(c));
        System.out.println();

        int[] d = new int[10];
        System.out.print("(d) ");
        for (int i = 0; i < d.length; i++) {
            d[i] = 2 * i + 2;
        }
        System.out.print(Arrays.toString(d));
        System.out.println();

        int[] e = new int[10];
        System.out.print("(e) ");
        for (int i = 0; i < e.length; i++) {
            e[i] = (int)Math.pow(i + 1, 2);
        }
        System.out.print(Arrays.toString(e));
        System.out.println();

        int[] f = new int[10];
        System.out.print("(f) ");
        for (int i = 0; i < f.length; i++) {
            if (i % 2 == 0) f[i] = 0;
            else f[i] = 1;
        }
        System.out.print(Arrays.toString(f));
        System.out.println();

        int[] g = new int[10];
        System.out.print("(g) ");
        for (int i = 0; i < g.length; i++) {
            g[i] = i % 5;
        }
        System.out.print(Arrays.toString(g));
        System.out.println();

        int[] h = new int[10];
        System.out.print("(h) ");
        for (int i = 0; i < h.length; i++) {
            if (i > 0)
                if (i % 2 == 0) h[i] = h[i - 1] + 1;
                else h[i] = h[i - 1] + 3;
        }
        System.out.print(Arrays.toString(h));
    }
}

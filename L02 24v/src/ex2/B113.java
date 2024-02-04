package ex2;

public class B113 {
    public static void main(String[] args) {
        //Information given:
        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = 0.55;
        double e = 44.5;
        double f = 5.9;

        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c);
        System.out.println(x);
        System.out.println(y);
    }
}

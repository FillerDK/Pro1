package ex2.b104;

public class MyPointApp {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint();
        MyPoint point2 = new MyPoint(10, 30.5);

        System.out.println(point1.distance(point2));
    }
}

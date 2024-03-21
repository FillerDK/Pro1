package ex2;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(MyPoint mP) {
        return Math.sqrt(Math.pow(this.x - mP.x, 2) + Math.pow(this.y - mP.y, 2));
    }

    public double distanceToPoint(double x, double y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public static double distance(MyPoint mP1, MyPoint mP2){
        return Math.sqrt(Math.pow(mP2.x - mP1.x, 2) + Math.pow(mP2.y - mP1.y, 2));
    }

    public String toString() {
        return String.format("Distance between point (%.2f, %.2f) and (%.2f, %.2f) is .2f", x, y, 10.0, 30.5);
    }
}

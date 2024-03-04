package ex2;

public class MyPoint {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(double x2, double y2) {
        return Math.sqrt((this.x - x2) * (this.x - x2) + (this.y - y2) * (this.y - y2));
    }

    public String toString() {
        return String.format("Distance between point (%.2f, %.2f) and (%.2f, %.2f) is %.2f", getX(), getY(), 10.0, 30.5, distance(10, 30.5));
    }
}

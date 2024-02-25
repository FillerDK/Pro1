package classEx.ex4a;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        double area;
        return area = width * height;
    }

    public double getPerimeter() {
        double perimeter;
        return perimeter = width * 2 + height * 2;
    }

    public String toString() {
        return String.format("Width = %.2f, height = %.2f, area = %.2f and perimeter = %.2f", width, height, getArea(), getPerimeter());
    }
}

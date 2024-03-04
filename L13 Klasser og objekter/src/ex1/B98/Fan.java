package ex1.B98;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    @Override
    public String toString() {
        if (isOn()) return String.format("Fan is on: (speed: %d, color: %s, radius: %.2f)", speed, color, radius);
        else return String.format("Fan is off: (color: %s, radius: %.2f)", color, radius);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        if (speed.equalsIgnoreCase("FAST")) this.speed = FAST;
        else if (speed.equalsIgnoreCase("MEDIUM")) this.speed = MEDIUM;
        else this.speed = SLOW;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn() {
        this.on = true;
    }

    public void setOff() {
        this.on = false;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

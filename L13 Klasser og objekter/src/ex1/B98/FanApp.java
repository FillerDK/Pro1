package ex1.B98;

public class FanApp {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed("fast");
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn();

        fan2.setSpeed("medium");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}

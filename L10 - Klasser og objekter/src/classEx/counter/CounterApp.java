package classEx.counter;

public class CounterApp {
    public static void main(String[] args) {
        Counter c1 = new Counter("Blue");
        c1.setName("Red");
        Counter c2 = new Counter("Green", 10);
        System.out.println("Test c1: " + c1);
        System.out.println("Test c2: " + c2);

        c1.click();
        c1.click();
        c1.click();
        System.out.println("Test c1: " + c1);
        System.out.println("Test c2: " + c2);

        System.out.println("Value of c1 is " + c1.getCount() +
                " and the name is: " + c1.getName());
        System.out.println("Value of c1 is " + c2.getCount() +
                " and the name is: " + c2.getName());
    }
}

package classEx.exercises;

public class Car {
    private String brand;
    private String color;
    private String regNo; // registration number
    private int km;

    public Car(String brand, String color, String regNo, int km) {
        this.brand = brand;
        this.color = color;
        this.regNo = regNo;
        this.km = km;
    }

    @Override
    public String toString() {
        return String.format("Car(%s, %s, %s, %d km)", brand, color, regNo, km);
    }

    public void getKm(int km) {
        this.km = km;
    }

    public int setKm(int newKm) {
        return this.km = newKm;
    }

    public void printCar() {
        System.out.println("****************");
        System.out.println("* " + brand + ", " + color);
        System.out.println("* " + regNo);
        System.out.println("* " + km + " km");
        System.out.println("****************");
    }
}

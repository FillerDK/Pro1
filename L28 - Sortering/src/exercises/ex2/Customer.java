package exercises.ex2;

public class Customer implements Comparable<Customer> {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + "-" + age;
    }

    @Override
    public int compareTo(Customer other) {
        if (this.name.compareTo(other.name) == 0) {
            return Integer.compare(this.age, other.age);
        } else {
            return this.name.compareTo(other.name);
        }
    }
}

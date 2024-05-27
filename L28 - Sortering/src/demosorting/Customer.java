package demosorting;

public class Customer implements Comparable<Customer> {
    private final String name;
    private final int score;

    public Customer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "-" + score;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.score, other.score);
    }
}

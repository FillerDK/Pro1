package classEx.counter;

public class Counter {
    private String name;
    private int count;

    public Counter(String name) {
        this.name = name;
        count = 0;
    }

    public Counter(String name, int initialCount) {
        this.name = name;
        count = initialCount;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void click() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public String toString() {
        return "Counter(" + name + ", " + count + ")";
    }
}

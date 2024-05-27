package ex1;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public int compareTo(Customer other) {
        int lastName = this.lastName.compareTo(other.lastName);
        if (lastName == 0) {
            return this.firstName.compareTo(other.firstName);
        } else {
            return lastName;
        }
    }
}

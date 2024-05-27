package ex1;

import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        // Customers
        Customer c1 = new Customer("Hans", "Hansen");
        Customer c2 = new Customer("Jens", "Hansen");
        Customer c3 = new Customer("Bob", "Nielsen");

        Customer c4 = new Customer("Hans", "Jensen");
        Customer c5 = new Customer("Bob", "Madsen");
        Customer c6 = new Customer("Mads", "Sørensen");

        // L1
        ArrayList<Customer> customers1 = new ArrayList<>();
        customers1.add(c1);
        customers1.add(c2);
        customers1.add(c3);

        // L2
        ArrayList<Customer> customers2 = new ArrayList<>();
        customers2.add(c4);
        customers2.add(c5);
        customers2.add(c6);

        // Printing merged customers
        System.out.println(mergeAllCustomers(customers1, customers2));
    }

    /**
     * Return a sorted list containin all customers
     * from the lists l1 and l2.
     * Pre: l1 and l2 are sorted.
     */
    public static ArrayList<Customer> mergeAllCustomers(
            ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            Customer c1 = l1.get(i1);
            Customer c2 = l2.get(i2);

            if (c1.compareTo(c2) <= 0) {
                result.add(c1);
                i1++;
            } else {
                result.add(c2);
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }

        return result;
    }
}

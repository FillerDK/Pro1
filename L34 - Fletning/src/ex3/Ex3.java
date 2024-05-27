package ex3;

import java.util.ArrayList;

public class Ex3 {
    public static void main(String[] args) {
        // Customers
        Customer c1 = new Customer("Hans", "Hansen");   // good
        Customer c2 = new Customer("Jens", "Hansen");   // slow
        Customer c3 = new Customer("Hans", "Jensen");   // good
        Customer c4 = new Customer("Bob", "Madsen");    // slow
        Customer c5 = new Customer("Bob", "Nielsen");   // good
        Customer c6 = new Customer("Mads", "Sørensen"); // slow

        // L1
        ArrayList<Customer> shopCustomers = new ArrayList<>();
        shopCustomers.add(c1);
        shopCustomers.add(c2);
        shopCustomers.add(c3);
        shopCustomers.add(c4);
        shopCustomers.add(c5);
        shopCustomers.add(c6);

        // L2
        Customer[] slowPayers = new Customer[3];
        slowPayers[0] = c2;
        slowPayers[1] = c4;
        slowPayers[2] = c6;

        // Printing good customers
        System.out.println(goodCustomers(shopCustomers, slowPayers));
    }

    /**
     * Return a sorted ArrayList containing all customers
     * from l1 that are not in l2.
     * Pre: l1 and l2 are sorted and l2 has no empty
     * entries.
     */
    public static  ArrayList<Customer> goodCustomers(
            ArrayList<Customer> l1, Customer[] l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            Customer c1 = l1.get(i1);
            Customer c2 = l2[i2];
            if (c1.compareTo(c2) < 0) {
                result.add(c1);
                i1++;
            } else if (c1.compareTo(c2) > 0) {
                i2++;
            } else if (c1.compareTo(c2) == 0) {
                i1++;
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        return result;
    }
}

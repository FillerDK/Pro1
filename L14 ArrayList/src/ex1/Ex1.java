package ex1;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        // 1
        ArrayList<String> names = new ArrayList<>();
        //2
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");
        // 3
        System.out.println(names.size());
        // 4
        names.add(2, "Jane");
        // 5
        System.out.println(names);
        // 6
        names.remove(1);
        // 7
        names.addFirst("Pia");
        // 8
        names.addLast("Ib");
        // 9
        System.out.println(names.size());
        // 10
        names.add(2, "Hansi");
        // 11
        System.out.println(names.size());
        // 12
        System.out.println(names);
        // 13
        for (int i = 0; i < names.size(); i++)
            System.out.print(names.get(i) + " ");
        System.out.println();
        // 14
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
}

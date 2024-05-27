package literatur;

public class B362 {
    public static void main(String[] args) {
        int count = 10;
        boolean yo = count % 10 == 0;
        boolean newLine;

        if (yo) {
            newLine = true;
        } else {
            newLine = false;
        }

        System.out.println(newLine);
    }
}

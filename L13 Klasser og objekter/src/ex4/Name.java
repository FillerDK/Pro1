package ex4;

public class Name {
    public static void main(String[] args) {
        Name piotr = new Name("Piotr", "Suski");
        Name margrethe = new Name("Margrethe", "Sophie", "Dybdahl");
        System.out.println(piotr.getFullName());
        System.out.println(piotr.username());
        System.out.println(piotr.getInits());
        System.out.println(piotr.getCryptoInits(2));
    }

    String firstName;
    String middleName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = null;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFullName() {
        if (middleName == null)
            return String.format("%s %s", firstName, lastName);
        else return String.format("%s %s %s", firstName, middleName, lastName);
    }

    public String getInits() {
        if (middleName == null)
            return String.format("%s%s", firstName.charAt(0), lastName.charAt(0));
        else return String.format("%s%s%s", firstName.charAt(0), middleName.charAt(0), lastName.charAt(0));
    }

    public String getCryptoInits(int count) {
        char ch1 = (char) (firstName.charAt(0) + count);
        char ch3 = (char) (lastName.charAt(0) + count);
        if (middleName == null) {
            return "" + ch1 + ch3;
        } else {
            char ch2 = (char) (middleName.charAt(0) + count);
            return "" + ch1 + ch2 + ch3;
        }
    }

    public String username() {
        int lenghtMiddleName = (middleName != null) ? middleName.length() : 0;
        return String.format("%s%d%s", firstName.substring(0, 2).toUpperCase(), lenghtMiddleName, lastName.substring(lastName.length() - 2, lastName.length()).toLowerCase());
    }
}

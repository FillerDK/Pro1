package ex4;

public class Name {
    public static void main(String[] args) {
        Name name = new Name("Margrethe", "test", "Dybdahl");
        System.out.println(name.getFullName());
        System.out.println(name.username());
        System.out.println(name.getInits());
        System.out.println(name.getCryptoInits(1));
    }

    String firstName;
    String middleName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
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
        String cryptoInits = getInits();
        for (int i = 0; i < getInits().length(); i++) {
          //  cryptoInits = getInits().replace(getInits().charAt(i), getInits());
        } return cryptoInits;
    }

    public String username() {
        if (middleName == null)
            return String.format("%s%d%s", firstName.substring(0, 2).toUpperCase(), 0, lastName.substring(lastName.length() - 2, lastName.length()).toLowerCase());
        else return String.format("%s%d%s", firstName.substring(0, 2).toUpperCase(), middleName.length(), lastName.substring(lastName.length() - 2, lastName.length()).toLowerCase());
    }
}

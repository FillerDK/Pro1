package ex3.model;

public class Gift {
    private final String description;
    private int price;

    private final Person gives;
    private Person recieves; // nullable

    public Gift(String description, Person giver) {
        this.description = description;
        this.gives = giver;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    // -----------------------------------------------------

    public Person getGives() {
        return gives;
    }

    public Person getRecieves() {
        if (recieves != null)
            return recieves;
        else return null;
    }

    public void addReciever(Person reciever) {
        this.recieves = reciever;
    }
}

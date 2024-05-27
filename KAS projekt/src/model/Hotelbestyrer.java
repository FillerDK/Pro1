package model;

public class Hotelbestyrer extends Person {

    /**
     * Association 1 --> 0..1 Hotel
     * Note: Nullable
     */
    private Hotel hotel;

    public Hotelbestyrer(String name, String tlf, String email, String adresse) {
        super(name, tlf, email, adresse);
    }

    /**
     * Note: Nullable return value.
     */
    public Hotel hentHotel() {
        return hotel;
    }

    /**
     * Note: Nullable param group.
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

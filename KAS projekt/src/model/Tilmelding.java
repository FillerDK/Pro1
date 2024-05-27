package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Tilmelding implements Comparable<Tilmelding> {
    private final boolean foredragsholder;
    private final LocalDate ankomstDato;
    private final LocalDate afrejseDato;

    private final ArrayList<Service> services;

    /*
     * Forced association 0..* --> 1 Deltager
     * */
    private final Deltager deltager;

    /*
     * Composition 0..* --> 1 Konference
     * */
    private final Konference konference;

    /*
     * Association 1 --> 0..1 Ledsager
     * Note: Nullable
     * */
    private Ledsager ledsager;

    /*
     * Association 0..* --> 0..1 Hotel
     * Note: Nullable
     * */
    private Hotel hotel;

    /*
     * Association 0..* --> 0..1 Firma
     * Note: Nullable
     * */
    private Firma firma;

    public Tilmelding(
            boolean foredragsholder,
            LocalDate ankomstDato,
            LocalDate afrejseDato,
            Deltager deltager,
            Konference konference
    ) {
        this.foredragsholder = foredragsholder;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.deltager = deltager;
        this.konference = konference;
        this.services = new ArrayList<>();
    }


    /**
     * Returner prisen for tilmelding
     */
    public int beregnPris() {
        int pris = 0;

        // Antal dage deltageren er tilmeldt konferencen.
        int days = Period.between(this.ankomstDato, this.afrejseDato).getDays() + 1;

        // Pris for konferencen de dage deltageren er tilmeldt.
        if (!this.foredragsholder) {
            pris = days * this.konference.hentKonferenceAfgift();
        }

        // Check om ledsager er med
        if (this.ledsager != null) {
            // Check om hotel er reserveret
            if (this.hotel != null) {
                pris += (days - 1) * this.hotel.hentDobbeltVærelsesPris();

                if (!this.hentServices().isEmpty()) {
                    for (Service service : this.hentServices()) {
                        pris += (days - 1) * service.hentPris();
                    }
                }
            }
            // Pris for ledsagerens udflugter
            pris += ledsager.prisForUdflugter();

        } else {
            if (hotel != null) {
                if (!this.hentServices().isEmpty()) {
                    for (Service service : this.hentServices()) {
                        pris += service.hentPris();
                    }
                }
                pris += (days - 1) * this.hotel.hentEnkeltVærelsesPris();
            }
        }
        return pris;
    }


    public void addService(Service service) {
        this.services.add(service);
    }

    public void fjernService(Service service) {
        this.services.remove(service);
    }

    /**
     * Fjerner alle servides fra listen servies
     */
    public void fjernServices() {
        this.services.clear();
    }

    public ArrayList<Service> hentServices() {
        return new ArrayList<>(this.services);
    }

    public Konference hentKonference() {
        return konference;
    }

    // Getter and setter

    public boolean erForedragsholder() {
        return foredragsholder;
    }

    public LocalDate hentAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate hentAfrejseDato() {
        return afrejseDato;
    }

    public Deltager hentDeltager() {
        return deltager;
    }

    /**
     * Note: Nullable return value.
     */
    public Ledsager hentLedsager() {
        return ledsager;
    }

    /**
     * Note: Nullable param group.
     */
    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
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

    /**
     * Note: Nullable return value.
     */
    public Firma hentFirma() {
        return firma;
    }

    /**
     * Note: Nullable param group.
     */
    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return String.format(
                "%s Fra: %s Til: %s",
                konference.hentNavn(),
                this.ankomstDato,
                this.afrejseDato
        );
    }

    /**
     * Compare to method (Samlign deltager navn)
     */
    @Override
    public int compareTo(Tilmelding other) {
        return this.deltager.hentNavn().compareTo(other.deltager.hentNavn());
    }


}

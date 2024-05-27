package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Opretter og gemmer en ny deltager i systemet.
     *
     * @param navn        Navnet på deltageren
     * @param tlf         Telefonnummer for deltageren
     * @param email       Emailadresse for deltageren
     * @param adresse     Adresse for deltageren
     * @param adgangskode Adgangskode for deltageren
     * @return Den oprettede Deltager.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Deltager opretDeltager(
            String navn,
            String tlf,
            String email,
            String adresse,
            String adgangskode
    ) {
        if (navn == null ||
                navn.isEmpty() ||
                tlf == null ||
                tlf.isEmpty() ||
                email == null ||
                email.isEmpty() ||
                adresse == null ||
                adresse.isEmpty() ||
                adgangskode == null ||
                adgangskode.isEmpty()) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af deltager.");
        }
        Deltager deltager = new Deltager(
                navn,
                tlf,
                email,
                adresse,
                adgangskode
        );
        Storage.storeDeltager(deltager);
        return deltager;
    }

    /**
     * Opretter og gemmer en ny konference i systemet.
     *
     * @param konferenceAfgift Afgift for konferencen
     * @param lokation         Lokationen for konferencen
     * @param tilmeldingsfrist Tilmeldingsfrist for konferencen
     * @param beskrivelse      Beskrivelse af konferencen .
     * @param slutDato         Slutdato for konferencen
     * @param startDato        Startdato for konferencen
     * @param navn             Navn på konferencen
     * @return Den oprettede Konference.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Konference opretKonference(
            int konferenceAfgift,
            String lokation,
            LocalDate tilmeldingsfrist,
            String beskrivelse,
            LocalDate slutDato,
            LocalDate startDato,
            String navn) {
        if (konferenceAfgift <= 0 ||
                lokation == null ||
                lokation.isEmpty() ||
                tilmeldingsfrist == null ||
                beskrivelse == null ||
                beskrivelse.isEmpty() ||
                slutDato == null ||
                startDato == null ||
                navn == null ||
                navn.isEmpty()) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af konference.");
        }
        Konference konference = new Konference(
                konferenceAfgift,
                lokation,
                tilmeldingsfrist,
                beskrivelse,
                slutDato,
                startDato,
                navn
        );
        Storage.storeKonferencer(konference);
        return konference;
    }

    /**
     * Opretter og gemmer et nyt Hotel-objekt i systemet.
     * Kræver gyldige parametre for at oprette hotellet.
     *
     * @param dobbeltVærelsesPris Pris for dobbeltværelse
     * @param enkeltVærelsesPris  Pris for enkeltværelse
     * @param adresse             Adresse for hotellet
     * @param navn                Navn på hotellet
     * @param hotelbestyrer       Hotelbestyrer for hotellet
     * @return Det oprettede Hotel-objekt.
     * @throws IllegalArgumentException hvis parametrene ikke er gyldige.
     */
    public static Hotel opretHotel(
            int dobbeltVærelsesPris,
            int enkeltVærelsesPris,
            String adresse,
            String navn,
            Hotelbestyrer hotelbestyrer
    ) {
        // Validering af parametre
        if (dobbeltVærelsesPris <= 0 ||
                enkeltVærelsesPris <= 0 ||
                adresse == null ||
                adresse.isEmpty() ||
                navn == null ||
                navn.isEmpty() ||
                hotelbestyrer == null) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af hotel.");
        }
        Hotel hotel = new Hotel(
                dobbeltVærelsesPris,
                enkeltVærelsesPris,
                adresse,
                navn,
                hotelbestyrer
        );
        Storage.storeHoteller(hotel);
        return hotel;
    }

    /**
     * Tilføjer et hotel til en konference.
     *
     * @param konference Konferencen, som hotellet skal tilføjes til
     * @param hotel      Hotellet, som skal tilføjes til konferencen
     * @throws IllegalArgumentException hvis konference eller hotel er null.
     */
    public static void addHotelTilKonference(Konference konference, Hotel hotel) {
        // Validering af parametre
        if (konference == null || hotel == null) {
            throw new IllegalArgumentException("Konference eller hotel må ikke være null.");
        }
        konference.addHotel(hotel);
    }

    /**
     * Opretter og returnerer en ny hotelbestyrer.
     *
     * @param name    Navnet på hotelbestyreren
     * @param tlf     Telefonnummer for hotelbestyreren
     * @param email   Emailadresse for hotelbestyreren
     * @param adresse Adresse for hotelbestyreren
     * @return Den oprettede Hotelbestyrer.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Hotelbestyrer opretHotelbestyrer(
            String name,
            String tlf,
            String email,
            String adresse
    ) {
        if (name == null ||
                name.isEmpty() ||
                tlf == null ||
                tlf.isEmpty() ||
                email == null ||
                email.isEmpty() ||
                adresse == null ||
                adresse.isEmpty()) {
            throw new IllegalArgumentException(
                    "Ugyldige parametre til oprettelse af hotelbestyrer."
            );
        }
        Hotelbestyrer hotelbestyrer = new Hotelbestyrer(name, tlf, email, adresse);
        return hotelbestyrer;
    }

    /**
     * Tilføjer en hotelbestyrer til et hotel
     *
     * @param hotel         Hotellet, som hotelbestyren skal tilføjes til
     * @param hotelbestyrer hotelbestyren som skal tilføjes til hotellet
     * @throws IllegalArgumentException hvis hotel eller hotelbestyrer er null.
     */
    public static void addHotelbestyrerTilHotel(Hotel hotel, Hotelbestyrer hotelbestyrer) {
        // Validering af parametre
        if (hotel == null || hotelbestyrer == null) {
            throw new IllegalArgumentException("Hotel eller hotelbestyrer må ikke være null.");
        }

        Hotelbestyrer oldHotelbestyrer = hotel.hentHotelbestyrer();
        if (oldHotelbestyrer != null) {
            oldHotelbestyrer.setHotel(null);
        }
        hotel.setHotelbestyrer(hotelbestyrer);
        hotelbestyrer.setHotel(hotel);
    }

    /**
     * Opretter og tilføjer en ny Service til et eksisterende Hotel.
     * Kræver gyldige parametre for at oprette og tilføje servicen.
     *
     * @param navn        Navn på servicen
     * @param beskrivelse Beskrivelse af servicen
     * @param pris        Pris for servicen
     * @param hotel       Hotel, som servicen tilføjes til
     * @return Det oprettede Service-objekt.
     * @throws IllegalArgumentException hvis parametrene ikke er gyldige.
     */
    public static Service opretService(String navn, String beskrivelse, int pris, Hotel hotel) {
        // Validering af parametre
        if (navn == null ||
                navn.isEmpty() ||
                beskrivelse == null ||
                beskrivelse.isEmpty() ||
                pris <= 0 ||
                hotel == null) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af service.");
        }

        Service service = new Service(navn, beskrivelse, pris);
        hotel.addService(service);
        return service;
    }

    /**
     * Opretter en ny Ledsager.
     * Kræver gyldige parametre for at oprette ledsageren.
     *
     * @param name    Navn på ledsageren
     * @param tlf     Telefonnummer for ledsageren
     * @param email   Emailadresse for ledsageren
     * @param adresse Adresse for ledsageren
     * @return Det oprettede Ledsager-objekt.
     * @throws IllegalArgumentException hvis parametrene ikke er gyldige.
     */
    public static Ledsager opretLedsager(String name, String tlf, String email, String adresse) {
        // Validering af parametre
        if (name == null ||
                name.isEmpty() ||
                tlf == null ||
                tlf.isEmpty() ||
                email == null ||
                email.isEmpty() ||
                adresse == null ||
                adresse.isEmpty()) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af ledsager.");
        }
        Ledsager ledsager = new Ledsager(name, tlf, email, adresse);
        return ledsager;
    }

    /**
     * Opretter og tilføjer en ny udflugt til en konference.
     *
     * @param beskrivelse Beskrivelse af udflugten
     * @param pris        Pris for udflugten
     * @param dato        Dato for udflugten
     * @param lokation    Lokation for udflugten
     * @param navn        Navn på udflugten
     * @param konference  Konferencen, som udflugten tilføjes til
     * @return Det oprettede Udflugt-objekt.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Udflugt opretUdflugt(
            String beskrivelse,
            int pris,
            LocalDate dato,
            String lokation,
            String navn,
            Konference konference
    ) {
        // Validering af parametre
        if (beskrivelse == null ||
                beskrivelse.isEmpty() ||
                pris <= 0 ||
                dato == null ||
                lokation == null ||
                lokation.isEmpty() ||
                navn == null ||
                navn.isEmpty() ||
                konference == null) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af udflugt.");
        }
        Udflugt udflugt = new Udflugt(beskrivelse, pris, dato, lokation, navn);
        konference.addUdflugt(udflugt);
        return udflugt;
    }


    /**
     * Tilføjer en ledsager til en udflugt.
     *
     * @param udflugt  Udflugten, som ledsageren tilføjes til
     * @param ledsager Ledsageren, som tilføjes til udflugten
     * @throws IllegalArgumentException hvis udflugt eller ledsager er null.
     */
    public static void addLedsagerTilUdflugt(Udflugt udflugt, Ledsager ledsager) {
        // Validering af parametre
        if (udflugt == null || ledsager == null) {
            throw new IllegalArgumentException("Udflugt eller ledsager må ikke være null.");
        }
        udflugt.addLedsager(ledsager);
        ledsager.addUdflugt(udflugt);
    }

    public static void fjernLedsagerFraUdflugt(Udflugt udflugt, Ledsager ledsager) {
        ledsager.fjernUdflugt(udflugt);
        udflugt.fjernLedsager(ledsager);
    }


    /**
     * Opretter firma
     *
     * @param navn Navnet på firmaet
     * @param tlf  Telefonnummer for firmaet
     * @param cvr  CVR-nummer for firmaet
     * @return Det oprettede Firma-objekt.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Firma opretFirma(String navn, String tlf, String cvr) {
        // Validering af parametre
        if (navn == null ||
                navn.isEmpty() ||
                tlf == null ||
                tlf.isEmpty() ||
                cvr == null ||
                cvr.isEmpty()) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af firma.");
        }
        Firma firma = new Firma(navn, tlf, cvr);
        return firma;
    }

    /**
     * Opretter og tilknytter en ny tilmelding til en konference og deltager
     *
     * @param foredragsholder Angiver om tilmeldingen er for en foredragsholder.
     * @param ankomstDato     Ankomstdato for tilmeldingen
     * @param afrejseDato     Afrejsedato for tilmeldingen
     * @param deltager        Deltageren, som tilmeldingen tilhører
     * @param konference      Konferencen, som tilmeldingen er tilhører
     * @return Den oprettede Tilmelding.
     * @throws IllegalArgumentException hvis nogen af parametrene er ugyldige.
     */
    public static Tilmelding opretTilmelding(
            boolean foredragsholder,
            LocalDate ankomstDato,
            LocalDate afrejseDato,
            Deltager deltager,
            Konference konference
    ) {
        // Validering af parametre
        if (ankomstDato == null ||
                afrejseDato == null ||
                afrejseDato.isBefore(ankomstDato) ||
                deltager == null ||
                konference == null
        ) {
            throw new IllegalArgumentException("Ugyldige parametre til oprettelse af tilmelding.");
        }

        Tilmelding tilmelding = new Tilmelding(
                foredragsholder,
                ankomstDato,
                afrejseDato,
                deltager,
                konference
        );
        deltager.addTilmelding(tilmelding);
        konference.addTilmelding(tilmelding);

        return tilmelding;
    }

    /**
     * Tilfløjer et hotel til en Tilmelding
     *
     * @param hotel      det valgte hotel i forbindelse med tilmeldingen
     * @param tilmelding tilmelding, som hotellet skal tilføjes til
     */
    public static void addTilmeldingTilHotel(Hotel hotel, Tilmelding tilmelding) {
        Hotel oldHotel = tilmelding.hentHotel();
        if (oldHotel != null) {
            oldHotel.fjernTilmelding(tilmelding);
        }
        hotel.addTilmelding(tilmelding);
        tilmelding.setHotel(hotel);
    }

    public static void fjernTilmeldingFraHotel(Tilmelding tilmelding) {
        tilmelding.hentHotel().fjernTilmelding(tilmelding);
        tilmelding.setHotel(null);
    }

    /**
     * Tilføjer en service til en tilmelding
     *
     * @param tilmelding Tilmelding som servicen skal tilføjes til
     * @param service    Servicen som skal tilføjes
     * @throws IllegalArgumentException hvis tilmelding eller service er null
     */
    public static void addServiceTilTilmelding(Tilmelding tilmelding, Service service) {
        if (tilmelding == null || service == null) {
            throw new IllegalArgumentException("Tilmelding eller service må ikke være null.");
        }
        tilmelding.addService(service);
    }

    /**
     * Fjern en valgt service fra en tilmelding
     *
     * @param tilmelding tilmeldingen som servicen skal fjernes fra
     * @param service    servicen som skal fjernes
     * @throws IllegalArgumentException hvis tilmelding eller service er null
     */
    public static void fjernServiceFraTilmelding(Tilmelding tilmelding, Service service) {
        if (tilmelding == null || service == null) {
            throw new IllegalArgumentException("Tilmelding eller service må ikke være null.");
        }
        tilmelding.fjernService(service);
    }

    /**
     * Fjerner alle services fra en tilmelding
     *
     * @param tilmelding tilmeldingen som alle servies skal fjernes fra
     * @throws IllegalArgumentException hvis tilmelding er null
     */
    public static void fjernServicesFraTilmelding(Tilmelding tilmelding) {
        if (tilmelding == null) {
            throw new IllegalArgumentException("Tilmelding må ikke være null.");
        }
        tilmelding.fjernServices();
    }

    /**
     * Tilføjer en ledsager til tilmelding
     * Pre: Ledsager er ikke tilknyttet nogen tilmelding
     *
     * @param tilmelding Tilmelding som ledsageren skal tilføjes til
     * @param ledsager   Ledsageren som skal tilføjes
     * @throws IllegalArgumentException hvis tilmelding eller ledsager er null
     */
    public static void addLedsagerTilTilmelding(Tilmelding tilmelding, Ledsager ledsager) {
        if (tilmelding == null || ledsager == null) {
            throw new IllegalArgumentException("Tilmelding eller ledsager må ikke være null.");
        }
        ledsager.setTilmelding(tilmelding);
        tilmelding.setLedsager(ledsager);
    }

    /**
     * Fjerner ledsager fra tilmelding samt tilmelding fra ledsager
     *
     * @param tilmelding tilmeldingen som ledsageren skal fjernes fra
     * @param ledsager   ledsageren som tilmeldingen skal fjernes fra
     * @throws IllegalArgumentException hvis tilmelding eller ledsager er null
     */
    public static void fjernLedsagerFraTilmelding(Tilmelding tilmelding, Ledsager ledsager) {
        if (tilmelding == null || ledsager == null) {
            throw new IllegalArgumentException("Tilmelding eller ledsager må ikke være null.");
        }
        tilmelding.setLedsager(null);
        ledsager.setTilmelding(null);
    }

    /**
     * Tilføjer en ledsager til tilmelding
     *
     * @param tilmelding Tilmelding som ledsageren skal tilføjes til
     * @param firma      Firmaet som skal tilføjes
     * @throws IllegalArgumentException hvis tilmelding eller firmaet er null
     */
    public static void addFirmaTilTilmelding(Tilmelding tilmelding, Firma firma) {
        if (tilmelding == null || firma == null) {
            throw new IllegalArgumentException("Tilmelding eller firmaet må ikke være null.");
        }
        tilmelding.setFirma(firma);
    }

    /**
     * Returnerer en kopi af listen over alle konferencer i systemet.
     * Dette sikrer, at den oprindelige liste ikke ændres uautoriseret.
     *
     * @return En kopi af ArrayListen med Konference-objekter,
     * der repræsenterer alle konferencer i systemet.
     */
    public static ArrayList<Konference> hentKonferencer() {
        return Storage.hentKonferencer();
    }

    /**
     * Returnerer en kopi af listen over alle Deltagere i systemet.
     * Dette sikrer, at den oprindelige liste ikke ændres uautoriseret.
     *
     * @return En kopi af ArrayListen med Deltager-objekter,
     * der repræsenterer alle Deltagere i systemet.
     */
    public static ArrayList<Deltager> hentDeltagere() {
        return Storage.hentDeltagere();
    }

    /**
     * Returnerer en kopi af listen over alle Hoteller i systemet.
     * Dette sikrer, at den oprindelige liste ikke ændres uautoriseret.
     *
     * @return En kopi af ArrayListen med Hotel-objekter,
     * der repræsenterer alle Hoteller i systemet.
     */
    public static ArrayList<Hotel> hentHoteller() {
        return Storage.hentHoteller();
    }

    /**
     * Returnerer en deltager baseret på angivet e-mail og adgangskode.
     *
     * @param email       E-mailadressen for den ønskede deltager
     * @param adgangskode Adgangskoden for den ønskede deltager
     * @return Deltagerobjektet, hvis e-mail og adgangskode matcher
     * en eksisterende deltager; ellers null.
     * @throws IllegalArgumentException hvis e-mail eller adgangskode
     *                                  er ugyldige (tomme eller null).
     */
    public static Deltager hentDeltager(String email, String adgangskode) {

        if (email == null || email.isEmpty() || adgangskode == null || adgangskode.isEmpty()) {
            throw new IllegalArgumentException("Ugyldige parametre til hentDeltager.");
        }

        ArrayList<Deltager> deltagers = Storage.hentDeltagere();
        Deltager foundDeltager = null;

        for (Deltager deltager : deltagers) {
            if (
                    deltager.hentAdgangskode().equals(adgangskode) &&
                            deltager.hentEmail().equals(email)) {
                foundDeltager = deltager;
            }
        }

        return foundDeltager;
    }

    /**
     * Returnerer en liste af deltagere for en konference
     *
     * @param konference konferencen for den ønskede liste
     * @return String array liste af alle deltagere for en konference
     * @throws IllegalArgumentException hvis konference er null
     */
    public static ArrayList<String> listeAfDeltagereForKonference(Konference konference) {
        // validering af parametre
        if (konference == null) {
            throw new IllegalArgumentException("Konference er null.");
        }

        ArrayList<Tilmelding> tilmeldinger = konference.hentTilmeldinger();

        // Selection sort
        for (int i = 0; i < tilmeldinger.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < tilmeldinger.size(); j++) {
                if (tilmeldinger.get(indexOfMin).compareTo(tilmeldinger.get(j)) > 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Tilmelding temp = tilmeldinger.get(i);
                tilmeldinger.set(i, tilmeldinger.get(indexOfMin));
                tilmeldinger.set(indexOfMin, temp);
            }
        }

        ArrayList<String> liste = new ArrayList<>();

        liste.add(String.format(
                "%s (fra: %s til: %s)",
                konference.hentNavn(), konference.hentStartDato(), konference.hentSlutDato())
        );

        for (Tilmelding tilmelding : tilmeldinger) {
            liste.add(String.format(
                    "\t%s %s",
                    tilmelding.hentDeltager().hentNavn(),
                    (tilmelding.hentLedsager() != null ?
                            "med " + tilmelding.hentLedsager().hentNavn() :
                            ""))
            );
            liste.add(String.format(
                    "\t\tFirma: %s",
                    (tilmelding.hentFirma() != null ?
                            tilmelding.hentFirma().hentNavn() :
                            "---Intet firma---"))
            );
            liste.add(String.format(
                    "\t\tForedragsholder: %s",
                    (tilmelding.erForedragsholder() ? "Ja" : "Nej"))
            );
            liste.add(String.format(
                    "\t\tFra: %s til %s",
                    tilmelding.hentAnkomstDato(), tilmelding.hentAfrejseDato())
            );
            liste.add(String.format(
                    "\t\tTelefon: %s",
                    tilmelding.hentDeltager().hentTlf())
            );
            liste.add(String.format(
                    "\t\tHotel %s",
                    (tilmelding.hentHotel() != null ?
                            tilmelding.hentHotel().hentNavn() :
                            "---Intet hotel---"))
            );

            if (tilmelding.hentHotel() != null) {
                if (!tilmelding.hentServices().isEmpty()) {
                    liste.add(String.format(
                            "\t\t\tEkstra service:"
                    ));

                    for (Service service : tilmelding.hentServices()) {
                        liste.add(String.format(
                                "\t\t\t\t%s",
                                (service.hentNavn())
                        ));
                    }
                } else {
                    liste.add(String.format(
                            "\t\t\t---Ingen ekstra service---"
                    ));
                }
            }
        }
        return liste;
    }

    /**
     * Returnerer en liste af alle udflugter givet en konfference
     *
     * @param konference Konference
     * @return String array liste af alle udlugter for en konference
     * @throws IllegalArgumentException hvis konference er null
     */
    public static ArrayList<String> listeAfUdflugterForKonference(Konference konference) {
        // validering af parametre
        if (konference == null) {
            throw new IllegalArgumentException("Konference er null.");
        }
        ArrayList<Udflugt> udflugter = konference.hentUdflugter();

        // Selection sort (Sorterer efter dato)
        for (int i = 0; i < udflugter.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < udflugter.size(); j++) {
                if (udflugter.get(indexOfMin).compareTo(udflugter.get(j)) > 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Udflugt temp = udflugter.get(i);
                udflugter.set(i, udflugter.get(indexOfMin));
                udflugter.set(indexOfMin, temp);
            }
        }

        ArrayList<String> liste = new ArrayList<>();

        liste.add(String.format(
                "%s (fra: %s til: %s)",
                konference.hentNavn(), konference.hentStartDato(), konference.hentSlutDato())
        );
        for (Udflugt udflugt : udflugter) {
            liste.add(
                    String.format("\t%s (%s)", udflugt.hentNavn(), udflugt.hentDato())
            );
            for (Ledsager ledsager : udflugt.hentLedsagere()) {
                liste.add(
                        String.format(
                                "\t\t%s (%s %s)",
                                ledsager.hentNavn(),
                                ledsager.hentTilmelding().hentDeltager().hentNavn(),
                                ledsager.hentTilmelding().hentDeltager().hentTlf())
                );
            }
        }

        return liste;
    }

    /**
     * Returnerer en liste af alle hoteller for alle konferencer
     */
    public static ArrayList<String> listeAfHoteller() {

        ArrayList<Konference> alleKonferencer = Storage.hentKonferencer();
        ArrayList<String> liste = new ArrayList<>();

        for (Konference konference : alleKonferencer) {
            liste.add(String.format(
                    "%s (fra: %s til: %s)",
                    konference.hentNavn(),
                    konference.hentStartDato(),
                    konference.hentSlutDato())
            );

            for (Hotel hotel : konference.hentHoteller()) {

                liste.add(String.format("\t%s", hotel.hentNavn()));
                liste.add(String.format("\t\tAdresse: %s", hotel.hentAdresse()));
                liste.add(String.format(
                        "\t\tHotelbestyrer: %s (%s)",
                        hotel.hentHotelbestyrer().hentNavn(),
                        hotel.hentHotelbestyrer().hentTlf())
                );

                for (Tilmelding tilmelding : hotel.hentTilmeldinger()) {
                    liste.add(String.format(
                                    "\t\t\t%s %s",
                                    tilmelding.hentDeltager().hentNavn(),
                                    (tilmelding.hentLedsager() != null ?
                                            "med " + tilmelding.hentLedsager().hentNavn() :
                                            "")
                            )
                    );
                }
            }
        }
        return liste;
    }

    /**
     * Fjerner en tilmelding for dens konference
     */
    public static void fjernTilmelding(Tilmelding tilmelding) {
        tilmelding.hentKonference().fjernTilmelding(tilmelding);
    }

    /**
     * Returnere true hvis bruger findes, og false hvis bruger ikke findes
     *
     * @param email brugerens email
     * @return boolean
     */
    public static boolean muligBruger(String email) {
        // Tjek om bruger med given mail allerede eksisterer
        ArrayList<Deltager> deltagere = Storage.hentDeltagere();
        Boolean muligBruger = true;

        for (Deltager deltager : deltagere) {
            if (deltager.hentEmail().equalsIgnoreCase(email)) {
                muligBruger = false;
            }
        }

        return muligBruger;
    }

    /**
     * Finder den første deltager med det angivet navn
     *
     * @param navn navnet på deltageren som ønskes fundet
     * @return Deltager med angivet navn hvis ekstierer ellers null
     */
    public static Deltager hentDeltager(String navn) {
        Deltager deltager = null;
        ArrayList<Deltager> deltagere = Storage.hentDeltagere();
        boolean found = false;
        int i = 0;
        while (!found && i < deltagere.size()) {
            if (navn.equals(deltagere.get(i).hentNavn())) {
                deltager = deltagere.get(i);
                found = true;
            } else {
                i++;
            }
        }
        return deltager;
    }


}
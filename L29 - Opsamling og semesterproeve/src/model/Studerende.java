package model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    public int antalFraværsLektioner() {
        int fraLektioner = 0;
        for (Deltagelse d : deltagelser) {
            if (d.erRegistreretFraværende()) {
                fraLektioner++;
            }
        }
        return fraLektioner;
    }
}

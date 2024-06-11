package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation>{
    // section S1
    private final LocalDateTime dato;
    private final LocalTime startTid;

    /**
     * Forced association 0..* --- 1 Bane
     */
    private final Bane bane;

    /**
     * Forced association 0..* --- 1 Medlem
     */
    private final Medlem booker;

    /**
     * Association 0..* --- 1 Medlem
     */
    private final Medlem makker;

    public Reservation(LocalDateTime dato, LocalTime startTid, Bane bane, Medlem booker,
                       Medlem makker) {
        this.dato = dato;
        this.startTid = startTid;
        this.bane = bane;
        this.booker = booker;
        this.makker = makker;
    }

    // getters
    public LocalDateTime getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public Bane getBane() {
        return bane;
    }

    public Medlem getBooker() {
        return booker;
    }

    public Medlem getMakker() {
        return makker;
    }

    @Override
    public int compareTo(Reservation other) {
        int dato = this.dato.compareTo(other.dato);
        if (dato == 0) {
            int startTid = this.getStartTid().compareTo(other.startTid);
            if (startTid == 0) {
                return Integer.compare(this.bane.getNummer(), other.bane.getNummer());
            } else {
                return startTid;
            }
        } else {
            return dato;
        }
    }
}

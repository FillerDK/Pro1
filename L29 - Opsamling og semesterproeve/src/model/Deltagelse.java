package model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    private Lektion lektion;
    private Studerende studerende;

    public Deltagelse(Lektion lektion, Studerende studerende) {
        this.lektion = lektion;
        this.studerende = studerende;
        registreret = false;
        status = DeltagerStatus.TILSTEDE;
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Lektion getLektion() {
        return lektion;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public boolean erRegistreretFraværende() {
        if (this.status != DeltagerStatus.TILSTEDE) {
            return true;
        } else {
            return false;
        }
    }
}

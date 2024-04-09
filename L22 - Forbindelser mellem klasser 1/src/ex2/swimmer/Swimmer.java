package ex2.swimmer;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double bestLapTime = lapTimes.get(0);
        for (double time : lapTimes) {
            if (time < bestLapTime) bestLapTime = time;
        }
        return bestLapTime;
    }
}

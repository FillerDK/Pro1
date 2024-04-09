package ex1.swimmer;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

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

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public int allTrainingHours() {
        int weeklyTrainingHours = trainingPlan.getWeeklyWaterHours() + trainingPlan.getWeeklyStrengthHours();
        return weeklyTrainingHours;
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

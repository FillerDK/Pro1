package ex2.swimmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwimmerApp {

    public static void main(String[] args) {
        TrainingPlan trainingPlanA = new TrainingPlan('A', 16, 10);
        TrainingPlan trainingPlanB = new TrainingPlan('B', 10, 6);

        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        trainingPlanA.addSwimmer(jan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        trainingPlanA.addSwimmer(bo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        trainingPlanB.addSwimmer(mikkel);

        ArrayList<TrainingPlan> trainingPlans = new ArrayList<>();

        ArrayList<Swimmer> swimmers = new ArrayList<>();

        trainingPlans.add(trainingPlanA);
        trainingPlans.add(trainingPlanB);



        for (TrainingPlan trainingPlan : trainingPlans) {
            for (Swimmer swimmer : trainingPlan.getSwimmers()) {
                swimmers.add(swimmer);
                System.out.println(printSwimmer(swimmer, trainingPlan));
            }
        }
    }

    public static String printSwimmer(Swimmer swimmer, TrainingPlan trainingPlan) {
        return String.format("Name: %s, training hours weekly: %d", swimmer.getName(), trainingPlan.totalTrainHours());
    }
}

package ex2;

import java.util.Scanner;

public class StopWatchApp {
    public static void main(String[] args) {
        StopWatch stopWatch1 = new StopWatch();
        System.out.print("Press enter to start the time:");
        Scanner changeSWStatus = new Scanner(System.in);
        String turnOnOff = changeSWStatus.nextLine();
        stopWatch1.start();
        System.out.print("Time started press enter again to stop the time:");
        turnOnOff = changeSWStatus.nextLine();
        stopWatch1.stop();
        System.out.printf("Time elapsed: %d,%ds", stopWatch1.elapsedTime(stopWatch1).toSeconds(), stopWatch1.elapsedTime(stopWatch1).toMillisPart());
    }
}

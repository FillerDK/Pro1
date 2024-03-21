package ex2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

public class StopWatch {
    LocalTime startTime;
    LocalTime endTime;

    public StopWatch() {
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }

    public Duration elapsedTime(StopWatch stopWatch) {
        Duration timeElapsed = Duration.between(startTime, endTime);
        return timeElapsed;
    }
}

package ss04_oop_class.exercise.stop_watch;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class StopWatch {
    private long startTime;
    private long endTime;

    StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void setStarTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return this.getEndTime()-this.getStartTime();
    }

}

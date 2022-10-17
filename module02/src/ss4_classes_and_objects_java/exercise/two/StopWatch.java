package ss4_classes_and_objects_java.exercise.two;

public class StopWatch {
    private long startTime, endTime;

    public StopWatch() {

    }

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void startTime() {

    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public void getElapsedTime() {
        System.out.println(endTime - startTime);
    }
}


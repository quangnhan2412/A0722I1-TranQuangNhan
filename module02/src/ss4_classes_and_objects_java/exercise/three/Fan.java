package ss4_classes_and_objects_java.exercise.three;

public class Fan {
    int Slow = 1;
    int Medium = 2;
    int Fast = 3;
    private int Speed = Slow;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    public int getSlow() {
        return Slow;
    }

    public int getMedium() {
        return Medium;
    }

    public int getFast() {
        return Fast;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn) {
            return "Fan is On{" +
                    "Slow=" + Slow +
                    ", Medium=" + Medium +
                    ", Fast=" + Fast +
                    ", Speed=" + Speed +
                    ", isOn=" + isOn +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is Off{" +
                    "Slow=" + Slow +
                    ", Medium=" + Medium +
                    ", Fast=" + Fast +
                    ", Speed=" + Speed +
                    ", isOn=" + isOn +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}

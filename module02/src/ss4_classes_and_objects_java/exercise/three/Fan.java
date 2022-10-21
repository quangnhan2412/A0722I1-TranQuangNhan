package ss4_classes_and_objects_java.exercise.three;

public class Fan {
    int slow = 1;
    int medium = 2;
    int fast = 3;
    private int Speed = slow;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
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
                    "Slow=" + slow +
                    ", Medium=" + medium +
                    ", Fast=" + fast +
                    ", Speed=" + Speed +
                    ", isOn=" + isOn +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is Off{" +
                    "Slow=" + slow +
                    ", Medium=" + medium +
                    ", Fast=" + fast +
                    ", Speed=" + Speed +
                    ", isOn=" + isOn +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}

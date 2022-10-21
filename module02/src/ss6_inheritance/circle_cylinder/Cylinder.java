package ss6_inheritance.circle_cylinder;

public class Cylinder extends Circle {
    private Double height = 5.0;

    public Cylinder() {

    }

    public Cylinder(Double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, Double height) {
        super(radius, color);
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * this.height;
    }

    @Override
    public String toString() {
        return "A Cylinder color of "
                + getColor()
                +" and "
                + "height "
                + this.height
                +" Volume "
                +getVolume();
    }
}

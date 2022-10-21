package ss5_accessmodifier_static_method_property.exercise.accessmodifier.one;

import org.w3c.dom.ls.LSOutput;

public class Circle {
    private double radius = 1.0;
    private String color = "Red";

    Circle() {

    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }


}

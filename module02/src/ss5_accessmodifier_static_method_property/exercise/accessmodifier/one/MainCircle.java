package ss5_accessmodifier_static_method_property.exercise.accessmodifier.one;

import ss5_accessmodifier_static_method_property.exercise.accessmodifier.one.Circle;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();

        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());

        Circle circleTwo = new Circle(10);
        System.out.println(circleTwo.getRadius());
        System.out.println(circleTwo.getArea());
    }

}

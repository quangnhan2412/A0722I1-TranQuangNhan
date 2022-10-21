package ss6_inheritance.circle_cylinder;

public class MainCircleCylinder {
    public static void main(String[] args) {
        Circle circleOne = new Circle();
        System.out.println(circleOne);

        circleOne = new Circle(2, "Red");
        System.out.println(circleOne);
        System.out.println();

        Cylinder cylinderOne = new Cylinder();
        System.out.println(cylinderOne);

        cylinderOne = new Cylinder(10,"Yellow",7.0);
        System.out.println(cylinderOne);

    }
}

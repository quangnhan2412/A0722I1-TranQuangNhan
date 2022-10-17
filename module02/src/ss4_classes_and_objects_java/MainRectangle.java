package ss4_classes_and_objects_java;

import java.util.Scanner;

public class MainRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(width, height);

        System.out.println("Your Rectangle \n" + rectangle1.display());
        System.out.println("Perimeter of the Rectangle: " + rectangle1.getPerimeter());
        System.out.println("Area of the Rectangle: " + rectangle1.getArea());
    }
}

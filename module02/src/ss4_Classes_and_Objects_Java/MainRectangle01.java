package ss4_Classes_and_Objects_Java;

import java.util.Scanner;

public class MainRectangle01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();

        Rectangle01 rectangle1 = new Rectangle01(width, height);

        System.out.println("Your Rectangle \n" + rectangle1.display());
        System.out.println("Perimeter of the Rectangle: " + rectangle1.getPerimeter());
        System.out.println("Area of the Rectangle: " + rectangle1.getArea());
    }
}

package ss4_Classes_and_Objects_Java;

import java.util.Scanner;

public class A1MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        double a = scanner.nextDouble();
        System.out.print("Enter b : ");
        double b = scanner.nextDouble();
        System.out.print("Enter c : ");
        double c = scanner.nextDouble();

        A1QuadraticEquation a1_quadraticEquation = new A1QuadraticEquation(a, b, c);
        if(a1_quadraticEquation.getDiscriminant() < 0 ){
            System.out.println("The equation has no roots");
        }else if(a1_quadraticEquation.getDiscriminant() == 0){
            System.out.println("The equation has no roots" + a1_quadraticEquation.getRoot1());
        }else {
            System.out.println("The equation has two roots: ");
            System.out.println("Root1 is: " + a1_quadraticEquation.getRoot1());
            System.out.println("Root2 is: " + a1_quadraticEquation.getRoot2());
        }
    }
}

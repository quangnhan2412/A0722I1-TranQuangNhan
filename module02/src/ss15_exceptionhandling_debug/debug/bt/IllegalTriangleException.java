package ss15_exceptionhandling_debug.debug.bt;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 value longs : ");
        double oneA = scanner.nextDouble();
        double twoB = scanner.nextDouble();
        double threeC = scanner.nextDouble();

        try {
            if (!(oneA > 0 && twoB > 0 && threeC > 0)) throw new ArithmeticException();
            else if (!(oneA + twoB > threeC && oneA + threeC > twoB && threeC + twoB > oneA))
                throw new ArithmeticException();
            else System.out.println("Re-enter the value");
        } catch (ArithmeticException e) {
            System.out.println("Invalid number input ");
        } finally {
            System.out.println("End ");
        }

    }

}

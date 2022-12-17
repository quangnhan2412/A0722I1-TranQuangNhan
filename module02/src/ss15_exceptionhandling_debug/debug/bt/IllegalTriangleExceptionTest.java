package ss15_exceptionhandling_debug.debug.bt;

import java.util.Scanner;

public class IllegalTriangleExceptionTest {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 value longs : ");
        double oneA = scanner.nextDouble();
        double twoB = scanner.nextDouble();
        double threeC = scanner.nextDouble();

        try {
            if (!(oneA > 0 && twoB > 0 && threeC > 0)) throw new IllegalTriangleException();
            else if (!(oneA + twoB > threeC && oneA + threeC > twoB && threeC + twoB > oneA))
                throw new ArithmeticException();
            else System.out.println("Re-enter the value");
        } catch (ArithmeticException e) {
            System.out.println("Invalid number input ");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End ");
        }

    }
}

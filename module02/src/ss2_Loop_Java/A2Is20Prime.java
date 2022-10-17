package ss2_Loop_Java;

import java.util.Scanner;

public class A2Is20Prime {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter n :");
        int n = scanner.nextInt();
        System.out.printf("%d số nguyên tố đầu tiên là: \n", n);
        int count = 0;//Đếm
        int i = 2;//Prime bắt đầu bằng 2
        while (count < n) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    //Check PRIME
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        //Check isPrime khi n>=2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

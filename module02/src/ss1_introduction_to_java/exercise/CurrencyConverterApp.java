package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter USD : ");
        usd = sc.nextDouble();
        double value = usd * vnd;
        System.out.println("Value USD " + value);
    }
}

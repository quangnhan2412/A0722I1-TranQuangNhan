package ss1_Introduction_to_Java;

import java.util.Scanner;

public class A3_Currency_converter_app {
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

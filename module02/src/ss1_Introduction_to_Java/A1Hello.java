package ss1_Introduction_to_Java;

import java.util.Scanner;

public class A1Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello: "+ name);
    }
}

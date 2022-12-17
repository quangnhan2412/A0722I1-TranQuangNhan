package module2.ultils;

import java.util.Scanner;

public class RegexChoice {
    public static Integer inputChoiceMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter a number : ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter a number!!!");
            }
        }
    }
}

package casestudy.ultils;

import java.util.Scanner;

public class RegexMenu {

    public static Integer inputChoiceMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter Number");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Enter a number !!!");
            }

        }
    }
}

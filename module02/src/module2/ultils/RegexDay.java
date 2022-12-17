package module2.ultils;

import casestudy.validate.AgeException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RegexDay {
    static Scanner scanner = new Scanner(System.in);
    public static LocalDate inputDay()  {
        LocalDate birthday;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            try {
                System.out.println("Enter Day Of Birth:");
                birthday = LocalDate.parse(scanner.nextLine(), dateFormat);
                LocalDate now = LocalDate.now();
                if (now.getYear() - birthday.getYear() < 18 || now.getYear() - birthday.getYear() > 100) {
                    throw new IOException("Age You must be over 18 years old and less than 100 years old");
                }
                return birthday;
            } catch (NumberFormatException | DateTimeParseException e) {
                System.err.println("Date of Birth Incorrect Format (yyyy-MM-dd)");
            } catch (IOException e) {
                System.out.println("Age You must be over 18 years old and less than 100 years old");

            }

        }
    }
    public static LocalDate dateInputDOB(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(userInput, dateFormat);
    }
}

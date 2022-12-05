package casestudy.ultils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class RegexPerson {
    static Scanner scanner = new Scanner(System.in);


    private static final String REGEX_NAME = "(^[A-Za-z]{3,16})([ ]{0,1})([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})";
    private static final String REGEX_ID_CARD = "[0-9]{9}";
    private static final String REGEX_NUMBER_PHONE = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private static final String REGEX_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final String REGEX_ID_EMPLOYEE = "[0-9]{3}";
    private static final String REGEX_POSITION = "([a-z])\\w+";
    private static final String REGEX_LEVEL = "([a-z])\\w+";
    private static final String REGEX_ID_CUSTOMER = "[0-9]{3}";
    private static final String REGEX_TYPE_CUSTOMER = "([a-z])\\w+";
    private static final String REGEX_ADDRESS = "[0-9]+ ([A-Z][a-z ]*)+";


    public static LocalDate inputBirthday() {
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
                System.out.println("Date of Birth Incorrect Format (yyyy-MM-dd)");
            } catch (IOException e) {
                System.out.println("Age You must be over 18 years old and less than 100 years old");
            }

        }
    }

    public static String inputFullName() {
        System.out.println("Enter first and last name : ");
        String fullName = scanner.nextLine();
        while (!fullName.matches(REGEX_NAME)) {
            System.out.println("You input bad format, please please get back !");
            fullName = scanner.nextLine();
        }
        return fullName;
    }

    public static Boolean inputGender() {
        System.out.println("Enter true (male) or incorrect (female) gender : ");
        boolean newGender = Boolean.parseBoolean(scanner.nextLine());
        return newGender;
    }

    public static String inputNewIDCard() {
        System.out.println("Enter identification card : ");
        String newIDCard = scanner.nextLine();
        while (!newIDCard.matches(REGEX_ID_CARD)) {
            System.out.println("You input bad format, please please get back !");
            newIDCard = scanner.nextLine();
        }
        return newIDCard;
    }

    public static String inputNewNumberPhone() {
        System.out.println("Enter Number Phone : ");
        String newNumberPhone = scanner.nextLine();
        while (!newNumberPhone.matches(REGEX_NUMBER_PHONE)) {
            System.out.println("You input bad format, please please get back !");
            newNumberPhone = scanner.nextLine();
        }
        return newNumberPhone;
    }

    public static String inputNewEmail() {
        System.out.println("Enter Email : ");
        String newEmail = scanner.nextLine();
        while (!newEmail.matches(REGEX_EMAIL)) {
            System.out.println("You input bad format, please please get back !");
            newEmail = scanner.nextLine();
        }
        return newEmail;
    }

    public static String inputNewEmployeeID() {
        System.out.println("Enter Employee ID : ");
        String newEmployeeID = scanner.nextLine();
        while (!newEmployeeID.matches(REGEX_ID_EMPLOYEE)) {
            System.out.println("You input bad format, please please get back !");
            newEmployeeID = scanner.nextLine();
        }
        return newEmployeeID;
    }

    public static String inputNewPosition() {
        System.out.println("Enter Position : ");
        String newPosition = scanner.nextLine();
        while (!newPosition.matches(REGEX_POSITION)) {
            System.out.println("You input bad format, please please get back !");
            newPosition = scanner.nextLine();
        }
        return newPosition;
    }

    public static Double inputNewSalary() {
        while (true) {
            try {
                System.out.println("Enter salary  ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number and !!!");
            }
        }
    }

    public static String inputNewLevel() {
        System.out.println("Enter Level ");
        String newLevel = scanner.nextLine();
        while (!newLevel.matches(REGEX_LEVEL)) {
            System.out.println("You input bad format, please please get back !");
            newLevel = scanner.nextLine();
        }
        return newLevel;
    }

    public static String inputCustomerID() {
        System.out.println("Enter customer ID ");
        String newCustomerID = scanner.nextLine();
        while (!newCustomerID.matches(REGEX_ID_CUSTOMER)) {
            System.out.println("You input bad format, please please get back !");
            newCustomerID = scanner.nextLine();
        }
        return newCustomerID;
    }

    public static String inputCustomerType() {
        System.out.println("Enter customer Type ");
        String newCustomerType = scanner.nextLine();
        while (!newCustomerType.matches(REGEX_TYPE_CUSTOMER)) {
            System.out.println("You input bad format, please please get back !");
            newCustomerType = scanner.nextLine();
        }
        return newCustomerType;
    }

    public static String inputAddress() {
        System.out.println("Enter Address ");
        String newAddress = scanner.nextLine();
        while (!newAddress.matches(REGEX_ADDRESS)) {
            System.out.println("You input bad format, please please get back !");
            newAddress = scanner.nextLine();
        }
        return newAddress;
    }
}

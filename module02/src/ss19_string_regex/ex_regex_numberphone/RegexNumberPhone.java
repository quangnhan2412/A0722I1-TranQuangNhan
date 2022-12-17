package ss19_string_regex.ex_regex_numberphone;

import java.util.Scanner;

public class RegexNumberPhone {
    private static final String REGEX_NUMBER_PHONE = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private static  final String REGEX_ID_CARD = "[0-9]+ ([A-Z][a-z ]*)+";

    public static boolean validateNumberPhoneVN(String numberPhone) {
        return numberPhone.matches(REGEX_ID_CARD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberPhone;
        do {
            System.out.println("Enter Number Phone");
            numberPhone = scanner.nextLine();
        } while (!validateNumberPhoneVN(numberPhone));
    }
}

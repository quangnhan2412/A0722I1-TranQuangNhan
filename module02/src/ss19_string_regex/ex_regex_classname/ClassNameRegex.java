package ss19_string_regex.ex_regex_classname;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameRegex {
    private static final String CLASSNAME_REGEX= "[CA]\\d{4}[GI]\\d";

    public ClassNameRegex() {
    }
    public static boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASSNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        String name;
        do{
            System.out.println("Enter name class ");
//            A0722I1
            name = scanner.nextLine();
        }while (!validate(name));
    }
}

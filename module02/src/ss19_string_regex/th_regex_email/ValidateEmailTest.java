package ss19_string_regex.th_regex_email;


public class ValidateEmailTest {
    private static ValidateEmail validateEmail;
    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" , "a@a.c"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        validateEmail = new ValidateEmail();
        for (String email : validEmail) {
            boolean isValid = validateEmail.validate(email);
            System.out.println("Email is : " + email + " is valid " + isValid);
        }
        for (String email : invalidEmail) {
            boolean isValid = validateEmail.validate(email);
            System.out.println("Email is : " + email + " is valid " + isValid);
        }
    }
}

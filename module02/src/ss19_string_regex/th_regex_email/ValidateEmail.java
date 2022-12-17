package ss19_string_regex.th_regex_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private  static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =   "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public ValidateEmail() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
     public boolean validate(String regex){
        matcher= pattern.matcher(regex);
        return matcher.matches();
     }


}

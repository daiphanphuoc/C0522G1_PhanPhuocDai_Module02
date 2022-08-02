package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static final String EMAIL_REGEX = "^[a-zA-Z][.\\w]{7,}@[a-z]{2,9}([.][a-z]{2,3}){1,2}$";

    public boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}

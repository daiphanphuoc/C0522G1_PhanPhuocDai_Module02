package ss19_regex.exercise.phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneRegex {

    public static final String PHONE_REGEX = "^\\([\\d]{2}\\)-\\(0[0-9]{9}\\)$";

    public PhoneRegex() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}

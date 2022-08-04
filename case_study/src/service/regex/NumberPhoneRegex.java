package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneRegex {
    public  NumberPhoneRegex() {
    }

    private static final String PHONE_REGEX = "^(84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";

    public boolean validate(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


}

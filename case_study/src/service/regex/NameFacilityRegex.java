package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFacilityRegex {
    private static final String NAME_REGEX = "^([ ]*[^\\d!@#$%^&*()_+./,-]{2,6}[ ]+)+[^\\d!@#$%^&*()_+.,/-]{1,6}[ ]*";

    public NameFacilityRegex() {
    }

    public boolean validate(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

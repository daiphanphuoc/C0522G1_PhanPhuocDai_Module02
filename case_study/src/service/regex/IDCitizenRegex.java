package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCitizenRegex {
    public static final String CITIZEN_REGEX = "[0-9]{12}";

    public IDCitizenRegex() {
    }

    public boolean validate(String iDCitizen) {
        Pattern pattern = Pattern.compile(CITIZEN_REGEX);
        Matcher matcher = pattern.matcher(iDCitizen);
        return matcher.matches();
    }
}

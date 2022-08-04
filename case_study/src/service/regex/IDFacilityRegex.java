package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDFacilityRegex {
    private final static String REGEX_FACILITY = "^SV(VL|HO|RO)\\-[\\d]{4}$";

    public boolean validate(String id) {
        Pattern pattern = Pattern.compile(REGEX_FACILITY);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }


}

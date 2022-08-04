package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDEmployeeRegex {
    private static final String ID_Employee_Regex = "[eE]-[0-9]{4}";

    public boolean validate(String iDEmployee) {
        Pattern pattern = Pattern.compile(ID_Employee_Regex);
        Matcher matcher = pattern.matcher(iDEmployee);
        return matcher.matches();
    }
}

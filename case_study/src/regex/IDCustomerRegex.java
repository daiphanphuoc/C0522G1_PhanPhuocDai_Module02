package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCustomerRegex {
    private static final String ID_Customer_Regex = "[cC]-[0-9]{4}";

    public boolean validate(String iDEmployee) {
        Pattern pattern = Pattern.compile(ID_Customer_Regex);
        Matcher matcher = pattern.matcher(iDEmployee);
        return matcher.matches();
    }
}

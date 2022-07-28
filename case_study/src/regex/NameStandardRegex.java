package regex;

import _exception.NameStandardException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameStandardRegex {
    private static final String NAME_REGEX="^([ ]*[^\\d!@#$%^&*()_+./-]{2,6}[ ]+){1,3}[^\\d!@#$%^&*()_+./-]{1,6}[ ]*$";

    public NameStandardRegex() {
    }

    public  boolean validate(String name){
        Pattern pattern=Pattern.compile(NAME_REGEX);
        Matcher matcher=pattern.matcher(name);
        return matcher.matches();
    }


}

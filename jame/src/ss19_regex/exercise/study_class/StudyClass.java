package ss19_regex.exercise.study_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudyClass {
    public static final String REGEX_CLASS = "[CAP][0-9]{4}[G-M]";

    public StudyClass() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(REGEX_CLASS);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}

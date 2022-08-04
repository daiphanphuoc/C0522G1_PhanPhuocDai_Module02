package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaTaiKhoanRegex {
    private final static String REGEX_TAIKHOAN = "^TK(TK|TT)\\-[\\d]{4}$";

    public boolean validate(String id) {
        Pattern pattern = Pattern.compile(REGEX_TAIKHOAN);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
}

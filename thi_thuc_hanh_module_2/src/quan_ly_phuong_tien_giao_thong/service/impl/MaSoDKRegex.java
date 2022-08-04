package quan_ly_phuong_tien_giao_thong.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaSoDKRegex {
    private final static String REGEX_SODK = "^[A-Z]\\d-\\d{4}$";

    public boolean validate(String id) {
        Pattern pattern = Pattern.compile(REGEX_SODK);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
}

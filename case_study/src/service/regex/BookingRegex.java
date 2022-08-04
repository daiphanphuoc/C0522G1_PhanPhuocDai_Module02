package service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingRegex {
    private static final String ID_BOOKING = "^BK[0-9]{2}-[0-9]{4}$";

    public static boolean validate(String iDBooking) {
        Pattern pattern = Pattern.compile(ID_BOOKING);
        Matcher matcher = pattern.matcher(iDBooking);
        return matcher.matches();
    }
}

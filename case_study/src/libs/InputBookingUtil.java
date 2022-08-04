package libs;

import _exception.facility.IDBookingException;
import service.regex.BookingRegex;

import static libs.InputUtil.*;

public class InputBookingUtil {

    public static String inputIDBooking(String target) {
        String iDBooking;
        while (true) {
            try {
                iDBooking = getString(target);
                if (!BookingRegex.validate(iDBooking)) {
                    throw new IDBookingException("Nhập vào mã booking không đúng định dạng 'BKxx-xxxx'");
                }
                break;
            } catch (IDBookingException e) {
                e.printStackTrace();
            }
        }

        return iDBooking;
    }
}

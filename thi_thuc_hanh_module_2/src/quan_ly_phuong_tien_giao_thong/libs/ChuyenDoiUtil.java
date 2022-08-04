package quan_ly_phuong_tien_giao_thong.libs;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChuyenDoiUtil {
    public static @NotNull String ngaySangChuoi(@NotNull LocalDate ngay) {
        String temp = ngay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return temp;
    }

    public static LocalDate chuoiSangNgay(String ngay) {
        LocalDate date = null;

        try {
            date = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return date;
    }
}

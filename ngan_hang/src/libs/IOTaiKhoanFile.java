package libs;

import models.TKThanhToan;
import models.TKTietKiem;
import models.TaiKhoan;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class IOTaiKhoanFile extends IOFile {
    public static @NotNull List<TaiKhoan> docTaiKhoanFile(String path) throws ParseException, NumberFormatException, DateTimeParseException {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        List<String> strings = null;
        try {
            strings = docFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr;
        assert strings != null;
        for (String s : strings) {
            arr = s.split(",");
            if (arr.length == 6) {
                LocalDate date = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                TaiKhoan tk = new TKThanhToan(Integer.parseInt(arr[0]), arr[1], arr[2], date,
                        arr[4], Double.parseDouble(arr[5]));
                taiKhoans.add(tk);
            } else if (arr.length == 8) {
                LocalDate ngayTao = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate ngayGui = LocalDate.parse(arr[5], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                TaiKhoan tk = new TKTietKiem(Integer.parseInt(arr[0]), arr[1], arr[2], ngayTao,
                        Double.parseDouble(arr[4]), ngayGui,
                        Double.parseDouble(arr[6]), Integer.parseInt(arr[7]));
                taiKhoans.add(tk);
            }
        }
        return taiKhoans;
    }

    public static void ghiTaiKhoanFile(String path, @NotNull List<TaiKhoan> taiKhoans) {
        StringBuilder duLieu = new StringBuilder();
        if (!taiKhoans.isEmpty()) {
            for (TaiKhoan taiKhoan : taiKhoans) {
                duLieu.append(taiKhoan.getInfo()).append("\n");
            }
            duLieu.deleteCharAt(duLieu.length() - 1);
        }
        try {
            ghiFile(path, duLieu.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

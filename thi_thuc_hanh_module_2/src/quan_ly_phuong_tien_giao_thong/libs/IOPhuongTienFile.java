package quan_ly_phuong_tien_giao_thong.libs;


import org.jetbrains.annotations.NotNull;
import quan_ly_phuong_tien_giao_thong.model.GiayDangKy;
import quan_ly_phuong_tien_giao_thong.model.PhuongTienGiaoThong;
import quan_ly_phuong_tien_giao_thong.model.XeOTo;
import quan_ly_phuong_tien_giao_thong.model.XeTai;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class IOPhuongTienFile extends IOFile {

    public static @NotNull List<GiayDangKy> docGDKPTFile(String path) throws ParseException, NumberFormatException, DateTimeParseException {
        List<GiayDangKy> giayDangKyList = new ArrayList<>();
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
            if (arr.length == 4) {
                LocalDate date = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                GiayDangKy tk = new GiayDangKy(arr[0], arr[1], arr[2], date);
                giayDangKyList.add(tk);
            }

        }
        return giayDangKyList;
    }

    public static void ghiGTKPTFile(String path, @NotNull List<GiayDangKy> giayDKList) {
        StringBuilder duLieu = new StringBuilder();
        if (!giayDKList.isEmpty()) {
            for (GiayDangKy giayDangKy : giayDKList) {
                duLieu.append(giayDangKy.layThongTin()).append("\n");
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
 public static @NotNull List<PhuongTienGiaoThong> docPhuongTienFile(String path) throws ParseException, NumberFormatException, DateTimeParseException {
        List<PhuongTienGiaoThong> taiKhoans = new ArrayList<>();
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
            if (arr.length == 7) {
                LocalDate date = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                PhuongTienGiaoThong tk = new XeTai(arr[0], arr[1], arr[2], date,
                        Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                taiKhoans.add(tk);
            } else if (arr.length == 8) {
                LocalDate date = LocalDate.parse(arr[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                PhuongTienGiaoThong tk = new XeOTo(arr[0], arr[1], arr[2], date,
                        Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Integer.parseInt(arr[6]), arr[7]);
                taiKhoans.add(tk);
            }
        }
        return taiKhoans;
    }

    public static void ghiPhuongTienFile(String path, @NotNull List<PhuongTienGiaoThong> phuongTienList) {
        StringBuilder duLieu = new StringBuilder();
        if (!phuongTienList.isEmpty()) {
            for (PhuongTienGiaoThong taiKhoan : phuongTienList) {
                duLieu.append(taiKhoan.layThongTin()).append("\n");
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

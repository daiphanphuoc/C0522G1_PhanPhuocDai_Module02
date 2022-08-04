package service.impl;

import libs.IOTaiKhoanFile;
import libs.InputUtil;
import models.Path;
import models.TKThanhToan;
import models.TaiKhoan;
import org.jetbrains.annotations.NotNull;
import service.TKThanhToanService;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TKThanhToanServiceImpl implements TKThanhToanService<TKThanhToan> {
    private static TKThanhToanServiceImpl tkThanhToanService;

    private TKThanhToanServiceImpl() {
    }

    public static TKThanhToanServiceImpl getInstance() {
        if (tkThanhToanService == null) {
            tkThanhToanService = new TKThanhToanServiceImpl();

        }
        return tkThanhToanService;
    }

    @Override
    public void them() {

    }

    @Override
    public void xoa(String maTaiKhoan) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                    System.out.println(taiKhoan);
                    if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa, nhấn true để xóa:")) {
                        taiKhoans.remove(taiKhoan);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void sua(String maTaiKhoan) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                    TaiKhoan tam = taoTKThanhToan(taiKhoan.getSoTaiKhoan(), taiKhoan.getMaTaiKhoan());
                    int index = taiKhoans.indexOf(taiKhoan);
                    taiKhoans.set(index, tam);
                    IOTaiKhoanFile.ghiTaiKhoanFile(Path.TAI_KHOAN.getPath(), taiKhoans);
                }
            }
        }
    }

    public @NotNull TKThanhToan taoTKThanhToan(int soTaiKhoan, String maTaiKhoan) {
        String tenChuTaiKhoan = InputUtil.inputNameStandard("Nhập vào tên chủ tài khoản:");
        LocalDate ngayTaoTaiKhoan = InputUtil.getLocalDate("Nhập vào ngày tạo tài khoản.");
        String soThe = InputUtil.getString("Nhập vào số thẻ:");
        double soTienTietKIem = InputUtil.getDouble("Nhập vào số tiền trong tk:");

        return new TKThanhToan(soTaiKhoan, maTaiKhoan, tenChuTaiKhoan,
                ngayTaoTaiKhoan, soThe, soTienTietKIem);
    }

    @Override
    public void hienThi() {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (taiKhoans.isEmpty()) {
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan instanceof TKThanhToan) {
                    System.out.println(taiKhoan);
                }
            }
        }
    }

    @Override
    public void timKiem(String data) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getMaTaiKhoan().contains(data) || taiKhoan.getTenChuTaiKhoan().contains(data)) {
                    System.out.println(taiKhoan);
                }
            }
        }
    }
}

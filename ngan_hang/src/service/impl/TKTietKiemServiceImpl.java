package service.impl;

import libs.IOTaiKhoanFile;
import libs.InputUtil;
import models.Path;
import models.TKThanhToan;
import models.TKTietKiem;
import models.TaiKhoan;
import org.jetbrains.annotations.NotNull;
import service.TKTietKiemService;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TKTietKiemServiceImpl implements TKTietKiemService<TKTietKiem> {
    private static TKTietKiemServiceImpl tietKiemService;
    private TKTietKiemServiceImpl(){}

    public static TKTietKiemServiceImpl getInstance(){
        if(tietKiemService==null){
            tietKiemService=new TKTietKiemServiceImpl();
        }
        return tietKiemService;
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
        if (taiKhoans.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan instanceof TKTietKiem) {
                    if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                        if (InputUtil.getBoolean("Nhập true để chắc chắn bạn muốn xóa:")) {
                            taiKhoans.remove(taiKhoan);
                        } else {
                            System.out.println("Bạn đã hủy xóa");
                            InputUtil.getString("Nhấn enter để trở về menu.");
                        }
                    }
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

        if (taiKhoans.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan instanceof TKTietKiem) {
                    if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                        TaiKhoan tam = taoTKTietKiem(taiKhoan.getSoTaiKhoan(), taiKhoan.getMaTaiKhoan());
                        int index = taiKhoans.indexOf(taiKhoan);
                        taiKhoans.set(index, tam);
                        IOTaiKhoanFile.ghiTaiKhoanFile(Path.TAI_KHOAN.getPath(), taiKhoans);
                    }
                }
            }
        }
    }

    public @NotNull TKTietKiem taoTKTietKiem(int soTaiKhoan, String maTaiKhoan) {
        String tenChuTaiKhoan = InputUtil.inputNameStandard("Nhập vào tên chủ tài khoản:");
        LocalDate ngayTaoTaiKhoan = InputUtil.getLocalDate("Nhập vào ngày tạo tài khoản.");
        double soTienTietKIem = InputUtil.getDouble("Nhập vào số tiền gửi tiết kiệm:");
        LocalDate ngayGui = InputUtil.getLocalDate("Nhập vào ngày gửi tiết kiệm");
        double laiSuat = InputUtil.getDouble("Nhập vào lãi suất theo năm:");
        int kyHan = InputUtil.getInt("Nhập vào kỳ hạn gửi , tính theo số tháng");
        return new TKTietKiem(soTaiKhoan, maTaiKhoan, tenChuTaiKhoan,
                ngayTaoTaiKhoan, soTienTietKIem, ngayGui, laiSuat, kyHan);
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
            System.out.println("Danh sách trống.");
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan instanceof TKTietKiem) {
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
        if (taiKhoans.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan instanceof TKTietKiem) {
                    if (taiKhoan.getMaTaiKhoan().contains(data) || taiKhoan.getTenChuTaiKhoan().contains(data)) {

                        System.out.println(taiKhoan);
                    }
                }
            }
        }
    }
}

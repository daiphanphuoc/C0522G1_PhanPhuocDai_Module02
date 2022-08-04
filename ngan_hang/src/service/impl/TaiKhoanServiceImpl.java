package service.impl;

import exception.TrungMaTaiKhoanException;
import libs.IOTaiKhoanFile;
import libs.InputUtil;
import models.Path;
import models.TKTietKiem;
import models.TaiKhoan;
import service.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.DataFormatException;

public class TaiKhoanServiceImpl implements Service<TaiKhoan> {
    private static TaiKhoanServiceImpl taiKhoanService;

    private TaiKhoanServiceImpl() {

    }

    public static TaiKhoanServiceImpl getInstance() {
        if (taiKhoanService == null) {
            taiKhoanService = new TaiKhoanServiceImpl();

        }
        return taiKhoanService;
    }

    @Override
    public void them() {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans.addAll(IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath()));
        } catch (ParseException|NumberFormatException e) {
            e.printStackTrace();
        }
        int soTaiKhoan;
        if (taiKhoans.isEmpty()) {
            soTaiKhoan = 1;
        } else {
            Collections.sort(taiKhoans);
            soTaiKhoan = taiKhoans.get(taiKhoans.size() - 1).getSoTaiKhoan() + 1;
        }
        String maTaiKhoan;
        while (true) {
            try {
                maTaiKhoan = InputUtil.nhapMaTaiKhoan("Nhập vào mã tài khoản:");
                for (TaiKhoan taiKhoan : taiKhoans) {
                    if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                        throw new TrungMaTaiKhoanException("Đã tồn tại mã tài khoản này " + maTaiKhoan);
                    }
                }
                break;
            } catch (TrungMaTaiKhoanException e) {
                e.printStackTrace();
            }
        }
        TaiKhoan taiKhoan;
        if (maTaiKhoan.contains("TKTT")) {
            taiKhoan = TKThanhToanServiceImpl.getInstance().taoTKThanhToan(soTaiKhoan, maTaiKhoan);

        } else {
            taiKhoan = TKTietKiemServiceImpl.getInstance().taoTKTietKiem(soTaiKhoan, maTaiKhoan);
        }
        taiKhoans.add(taiKhoan);
        IOTaiKhoanFile.ghiTaiKhoanFile(Path.TAI_KHOAN.getPath(), taiKhoans);
    }

    @Override
    public void xoa(String maTaiKhoan) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException|NumberFormatException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                System.out.println(taiKhoan);
                if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa, nhấn true để xóa:")) {
                    taiKhoans.remove(taiKhoan);
                    IOTaiKhoanFile.ghiTaiKhoanFile(Path.TAI_KHOAN.getPath(), taiKhoans);
                }
                break;
            }
        }
    }


    @Override
    public void sua(String maTaiKhoan) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans = IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath());
        } catch (ParseException|NumberFormatException e) {
            e.printStackTrace();
        }

        if (taiKhoans.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                    TaiKhoan tam;
                    if (taiKhoan instanceof TKTietKiem) {
                        tam = TKTietKiemServiceImpl.getInstance().
                                taoTKTietKiem(taiKhoan.getSoTaiKhoan(), taiKhoan.getMaTaiKhoan());
                    } else {
                        tam = TKThanhToanServiceImpl.getInstance().
                                taoTKThanhToan(taiKhoan.getSoTaiKhoan(), taiKhoan.getMaTaiKhoan());
                    }
                    int index = taiKhoans.indexOf(taiKhoan);
                    taiKhoans.set(index, tam);
                    IOTaiKhoanFile.ghiTaiKhoanFile(Path.TAI_KHOAN.getPath(), taiKhoans);
                }
            }
        }
    }


    @Override
    public void hienThi() {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans.addAll(IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath()));
        } catch (ParseException|NumberFormatException e) {
            e.printStackTrace();
        }
        if (!taiKhoans.isEmpty()) {
            for (TaiKhoan taiKhoan : taiKhoans) {
                System.out.println(taiKhoan);
            }

        }
    }

    @Override
    public void timKiem(String data) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans.addAll(IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!taiKhoans.isEmpty()) {
            for (TaiKhoan taiKhoan : taiKhoans) {
                if (taiKhoan.getTenChuTaiKhoan().contains(data)) {
                    System.out.println(taiKhoan);
                }
            }
        }
    }

    public void sapXep() {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            taiKhoans.addAll(IOTaiKhoanFile.docTaiKhoanFile(Path.TAI_KHOAN.getPath()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!taiKhoans.isEmpty()) {
            Collections.sort(taiKhoans, new Comparator<TaiKhoan>() {
                @Override
                public int compare(TaiKhoan o1, TaiKhoan o2) {
                    if (o1.getTenChuTaiKhoan().equals(o2.getTenChuTaiKhoan())) {
                        return o1.getMaTaiKhoan().compareTo(o2.getMaTaiKhoan());
                    }
                    return o1.getTenChuTaiKhoan().compareTo(o2.getTenChuTaiKhoan());
                }
            });
            for (TaiKhoan taiKhoan : taiKhoans) {
                System.out.println(taiKhoan);
            }

        }
    }
}

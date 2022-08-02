package service.impl;

import libs.IOTaiKhoanFile;
import libs.InputUtil;
import models.TKThanhToan;
import models.TaiKhoan;
import service.TKThanhToanService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TKThanhToanServiceImpl implements TKThanhToanService<TKThanhToan> {
    @Override
    public void add() {

    }

    @Override
    public void delete(String id) {
        List<TaiKhoan> tkTietKiems = new ArrayList<>();
        try {
            tkTietKiems = IOTaiKhoanFile.readTaiKhoanFile("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : tkTietKiems) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getIdTaiKhoan().equals(id)) {
                    System.out.println(taiKhoan);
                    if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa, nhấn true để xóa:")) {
                        tkTietKiems.remove(taiKhoan);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void update(String id) {
        List<TaiKhoan> tkTietKiems = new ArrayList<>();
        try {
            tkTietKiems = IOTaiKhoanFile.readTaiKhoanFile("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : tkTietKiems) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getIdTaiKhoan().equals(id)) {
                    //
                }
            }
        }
    }

    @Override
    public void display() {
        List<TaiKhoan> tkTietKiems = new ArrayList<>();
        try {
            tkTietKiems = IOTaiKhoanFile.readTaiKhoanFile("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : tkTietKiems) {

            System.out.println(taiKhoan);

        }
    }

    @Override
    public void find(String data) {
        List<TaiKhoan> tkTietKiems = new ArrayList<>();
        try {
            tkTietKiems = IOTaiKhoanFile.readTaiKhoanFile("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan : tkTietKiems) {
            if (taiKhoan instanceof TKThanhToan) {
                if (taiKhoan.getIdTaiKhoan().contains(data) || taiKhoan.getTenChuTaiKhoan().contains(data)) {
                    System.out.println(taiKhoan);
                }
            }
        }
    }
}

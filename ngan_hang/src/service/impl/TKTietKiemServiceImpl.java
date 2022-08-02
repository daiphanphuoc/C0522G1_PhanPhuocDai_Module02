package service.impl;

import libs.IOTaiKhoanFile;
import models.TKTietKiem;
import models.TaiKhoan;
import service.TKTietKiemService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TKTietKiemServiceImpl implements TKTietKiemService<TKTietKiem> {
    @Override
    public void add() {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void display() {

    }

    @Override
    public void find(String data) {
        List<TaiKhoan> tkTietKiems =new ArrayList<>();
        try {
            tkTietKiems= IOTaiKhoanFile.readTaiKhoanFile("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (TaiKhoan taiKhoan:tkTietKiems){
            if(taiKhoan instanceof TKTietKiem){
                if(taiKhoan.getIdTaiKhoan().contains(data)||taiKhoan.getTenChuTaiKhoan().contains(data)){

                    System.out.println(taiKhoan);
                }
            }
        }

    }
}

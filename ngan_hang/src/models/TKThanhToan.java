package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKThanhToan extends TaiKhoan{

    private String soThe;
    private double soTien;

    public TKThanhToan() {
    }

    public TKThanhToan(int soTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan,
                       LocalDate ngayTaoTaiKhoan, String soThe, double soTien) {
        super(soTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTien = soTien;
    }
    @Override
    public String getInfo() {
        String temp =getNgayTaoTaiKhoan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s,%s,%s,%s,%s,%s", getSoTaiKhoan(),getMaTaiKhoan(),getTenChuTaiKhoan(),
                temp,getSoThe(),getSoTien());
    }
    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "TKThanhToan{" +super.toString()+
                ", soThe='" + soThe + '\'' +
                ", soTien=" + soTien +
                "} " ;
    }


}

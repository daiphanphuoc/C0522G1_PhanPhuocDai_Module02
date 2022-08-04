package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKTietKiem extends TaiKhoan{
    private double soTienTietKIem;
    private LocalDate ngayGui;
    private double laiSuat;
    private int kyHan;

    public TKTietKiem() {
    }

    public TKTietKiem(int soTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, LocalDate ngayTaoTaiLhoan,
                      double soTienTietKIem, LocalDate ngayGui, double laiSuat, int kyHan) {
        super(soTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiLhoan);
        this.soTienTietKIem = soTienTietKIem;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public double getSoTienTietKIem() {
        return soTienTietKIem;
    }

    public void setSoTienTietKIem(double soTienTietKIem) {
        this.soTienTietKIem = soTienTietKIem;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "TKTietKiem{" +super.toString()+
                "soTienTietKIem=" + soTienTietKIem +
                ", ngayGui=" + ngayGui +
                ", laiSuat=" + laiSuat +
                ", kyHan=" + kyHan +
                "} "  ;
    }

    @Override
    public String getInfo() {
        String temp =getNgayTaoTaiKhoan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ngayGui=getNgayGui().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getSoTaiKhoan(),getMaTaiKhoan(),getTenChuTaiKhoan(),
                temp,getSoTienTietKIem(),getNgayGui(),getLaiSuat(),getKyHan());
    }
}

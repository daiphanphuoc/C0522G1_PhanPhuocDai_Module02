package quan_ly_phuong_tien_giao_thong.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class PhuongTienGiaoThong {
    private String maPhuongTien;
    private String tenPhuongTien;
    private String hangSanXuat;
    private LocalDate namSanXuat;
    private double congSuat;
    private double dungTich;

    public PhuongTienGiaoThong() {
    }

    public PhuongTienGiaoThong(String maPhuongTien, String tenPhuongTien,
                               String hangSanXuat, LocalDate namSanXuat,
                               double congSuat, double dungTich) {
        this.maPhuongTien = maPhuongTien;
        this.tenPhuongTien = tenPhuongTien;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.congSuat = congSuat;
        this.dungTich = dungTich;
    }

    public String getMaPhuongTien() {
        return maPhuongTien;
    }

    public void setMaPhuongTien(String maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public LocalDate getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(LocalDate namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    public double getDungTich() {
        return dungTich;
    }

    public void setDungTich(double dungTich) {
        this.dungTich = dungTich;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhuongTienGiaoThong that = (PhuongTienGiaoThong) o;
        return maPhuongTien.equals(that.maPhuongTien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhuongTien);
    }

    @Override
    public String toString() {
        return ", maPhuongTien='" + maPhuongTien + '\'' +
                ", tenPhuongTien='" + tenPhuongTien + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", congSuat=" + congSuat +
                ", dungTich=" + dungTich;
    }
    public abstract String layThongTin();
}

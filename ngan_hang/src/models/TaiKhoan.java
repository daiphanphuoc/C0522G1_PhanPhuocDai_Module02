package models;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public abstract class TaiKhoan implements Comparable<TaiKhoan>{
    private int soTaiKhoan;
    private String maTaiKhoan;
    private String tenChuTaiKhoan;
    private LocalDate ngayTaoTaiKhoan;

    public TaiKhoan() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return Objects.equals(maTaiKhoan, taiKhoan.maTaiKhoan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maTaiKhoan);
    }

    public TaiKhoan(int soTaiKhoan, String maTaiKhoan,
                    String tenChuTaiKhoan, LocalDate ngayTaoTaiLhoan) {
        this.soTaiKhoan = soTaiKhoan;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiLhoan;
    }

    public int getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(int soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public LocalDate getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(LocalDate ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return "idTaiKhoan='" + soTaiKhoan + '\'' +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenChuTaiKhoan='" + tenChuTaiKhoan + '\'' +
                ", ngayTaoTaiLhoan=" + ngayTaoTaiKhoan;
    }


    @Override
    public int compareTo(@NotNull TaiKhoan o) {
        return this.soTaiKhoan-o.soTaiKhoan;
    }

    public abstract String getInfo();
}

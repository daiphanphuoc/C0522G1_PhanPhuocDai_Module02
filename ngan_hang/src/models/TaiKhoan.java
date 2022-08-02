package models;

import java.time.LocalDate;

public abstract class TaiKhoan {
    private String idTaiKhoan;
    private String maTaiKhoan;
    private String tenChuTaiKhoan;
    private LocalDate ngayTaoTaiKhoan;

    public TaiKhoan() {
    }

    public TaiKhoan(String idTaiKhoan, String maTaiKhoan,
                    String tenChuTaiKhoan, LocalDate ngayTaoTaiLhoan) {
        this.idTaiKhoan = idTaiKhoan;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiLhoan;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
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

    public void setNgayTaoTaiLhoan(LocalDate ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return "idTaiKhoan='" + idTaiKhoan + '\'' +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenChuTaiKhoan='" + tenChuTaiKhoan + '\'' +
                ", ngayTaoTaiLhoan=" + ngayTaoTaiKhoan;
    }

    public abstract String getInfo();
}

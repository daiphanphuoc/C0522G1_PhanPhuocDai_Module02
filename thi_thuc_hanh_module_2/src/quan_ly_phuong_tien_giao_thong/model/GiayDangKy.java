package quan_ly_phuong_tien_giao_thong.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class GiayDangKy {
    private String soDangKy;
    private String tenChuPhuongTien;
    private String maPhuongTien;
    private LocalDate ngayDangKy;

    public GiayDangKy() {
    }

    public GiayDangKy(String soDangKy, String tenChuPhuongTien, String maPhuongTien, LocalDate ngayDangKy) {
        this.soDangKy = soDangKy;
        this.tenChuPhuongTien = tenChuPhuongTien;
        this.maPhuongTien = maPhuongTien;
        this.ngayDangKy = ngayDangKy;
    }
    public String layThongTin() {
        String ngay=ngayDangKy.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s,%s,%s,%s",soDangKy,tenChuPhuongTien,maPhuongTien,ngay);
    }
    public String getSoDangKy() {
        return soDangKy;
    }

    public void setSoDangKy(String soDangKy) {
        this.soDangKy = soDangKy;
    }

    public String getTenChuPhuongTien() {
        return tenChuPhuongTien;
    }

    public void setTenChuPhuongTien(String tenChuPhuongTien) {
        this.tenChuPhuongTien = tenChuPhuongTien;
    }

    public String getMaPhuongTien() {
        return maPhuongTien;
    }

    public void setMaPhuongTien(String maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    @Override
    public String toString() {
        return "GiayDangKy{" +
                "soDangKy='" + soDangKy + '\'' +
                ", tenChuPhuongTien='" + tenChuPhuongTien + '\'' +
                ", maPhuongTien='" + maPhuongTien + '\'' +
                ", ngayDangKy=" + ngayDangKy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiayDangKy that = (GiayDangKy) o;
        return soDangKy.equals(that.soDangKy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soDangKy);
    }


}

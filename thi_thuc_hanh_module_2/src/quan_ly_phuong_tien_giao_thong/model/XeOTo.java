package quan_ly_phuong_tien_giao_thong.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XeOTo extends PhuongTienGiaoThong {
    private int soChoNgoi;
    private String loaiDongCo;

    public XeOTo() {
    }

    public XeOTo(String maPhuongTien, String tenPhuongTien, String hangSanXuat, LocalDate namSanXuat,
                 double congSuat, double dungTich, int soChoNgoi, String loaiDongCo) {
        super(maPhuongTien, tenPhuongTien, hangSanXuat, namSanXuat, congSuat, dungTich);
        this.soChoNgoi = soChoNgoi;
        this.loaiDongCo = loaiDongCo;
    }

    @Override
    public String layThongTin() {
        String temp =getNamSanXuat().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getMaPhuongTien(),getTenPhuongTien(),
                getHangSanXuat(),temp,getCongSuat(),getDungTich(),soChoNgoi,loaiDongCo);
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getLoaiDongCo() {
        return loaiDongCo;
    }

    public void setLoaiDongCo(String loaiDongCo) {
        this.loaiDongCo = loaiDongCo;
    }

    @Override
    public String toString() {
        return "XeOTo{" + super.toString() +
                "soChoNgoi=" + soChoNgoi +
                ", loaiDongCo='" + loaiDongCo + '\'' +
                "} ";
    }


}

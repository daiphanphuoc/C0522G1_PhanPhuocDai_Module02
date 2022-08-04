package quan_ly_phuong_tien_giao_thong.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XeTai extends PhuongTienGiaoThong {
    private double trongTai;

    public XeTai() {
    }

    public XeTai(String maPhuongTien, String tenPhuongTien, String hangSanXuat,
                 LocalDate namSanXuat, double congSuat, double dungTich, double trongTai) {
        super(maPhuongTien, tenPhuongTien, hangSanXuat, namSanXuat, congSuat, dungTich);
        this.trongTai = trongTai;
    }


    @Override
    public String layThongTin() {
        String temp =getNamSanXuat().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s,%s,%s,%s,%s,%s,%s",getMaPhuongTien(),getTenPhuongTien(),
                getHangSanXuat(),temp,getCongSuat(),getDungTich(),trongTai);
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" + super.toString() +
                "trongTai=" + trongTai +
                "} ";
    }


}

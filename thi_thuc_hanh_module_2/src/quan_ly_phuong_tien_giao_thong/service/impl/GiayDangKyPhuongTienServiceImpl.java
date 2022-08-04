package quan_ly_phuong_tien_giao_thong.service.impl;

import quan_ly_phuong_tien_giao_thong.exception.MaSoDKException;
import quan_ly_phuong_tien_giao_thong.libs.IOPhuongTienFile;
import quan_ly_phuong_tien_giao_thong.libs.InputUtil;
import quan_ly_phuong_tien_giao_thong.model.GiayDangKy;
import quan_ly_phuong_tien_giao_thong.model.PhuongTienGiaoThong;
import quan_ly_phuong_tien_giao_thong.service.GiayDangKyPhuongTienService;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GiayDangKyPhuongTienServiceImpl implements GiayDangKyPhuongTienService<GiayDangKy> {
    public static final String DUONG_DAN_GDKPT = "thi_thuc_hanh_module_2/src/quan_ly_phuong_tien_giao_thong/du_lieu/gdkpt.csv";
    public static final String DUONG_DAN_PHUONG_TIEN = "thi_thuc_hanh_module_2/src/quan_ly_phuong_tien_giao_thong/du_lieu/phuongTien.csv";
    private static GiayDangKyPhuongTienServiceImpl phuongTienService;

    private GiayDangKyPhuongTienServiceImpl() {
    }

    public static GiayDangKyPhuongTienServiceImpl getInstance() {
        if (phuongTienService == null) {
            phuongTienService = new GiayDangKyPhuongTienServiceImpl();
        }
        return phuongTienService;
    }

    @Override
    public void dangKy() {
        List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();
        List<GiayDangKy> giayDangKyList = new ArrayList<>();
        try {
            phuongTienGiaoThongs.addAll(IOPhuongTienFile.docPhuongTienFile(DUONG_DAN_PHUONG_TIEN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (phuongTienGiaoThongs.isEmpty()) {
            System.out.println("Không tồn tại phương tiện để đăng ký");
        } else {

            try {
                giayDangKyList.addAll(IOPhuongTienFile.docGDKPTFile(DUONG_DAN_GDKPT));
            } catch (ParseException | NumberFormatException e) {
                e.printStackTrace();
            }
            String soDangKy;
            while (true) {
                try {
                    soDangKy = InputUtil.nhapMaSoDK("Nhập vào mã số đăng ký");
                    if (!giayDangKyList.isEmpty()) {
                        for (GiayDangKy giayDangKy : giayDangKyList) {
                            if (giayDangKy.getSoDangKy().equals(soDangKy)) {
                                throw new MaSoDKException("Trùng mã số đăng ký");
                            }
                        }
                    }
                    break;
                } catch (MaSoDKException e) {
                    e.printStackTrace();
                }
            }


            String tenChuPhuongTien = InputUtil.inputNameStandard("Nhập vào tên chủ phương tiện:");

            LocalDate ngayDangKy = InputUtil.getLocalDate("nhập vào ngày đăng ký phương tiên");

            String maPhuongTien;
            while (true) {
                try {
                    for (PhuongTienGiaoThong phuongTienGiaoThong : phuongTienGiaoThongs) {
                        System.out.println(phuongTienGiaoThong.getMaPhuongTien() + "  " + phuongTienGiaoThong.getTenPhuongTien());
                    }
                    maPhuongTien = InputUtil.getString("chọn mã phương tiện");
                    boolean isPhuongTien = false;
                    for (PhuongTienGiaoThong phuongTienGiaoThong : phuongTienGiaoThongs) {
                        if (phuongTienGiaoThong.getMaPhuongTien().equals(maPhuongTien)) {
                            isPhuongTien = true;
                            break;
                        }
                    }
                    if (!isPhuongTien) {

                        throw new Exception("không tông tại phương tiện., nhập lại.");

                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            giayDangKyList.add(new GiayDangKy(soDangKy, tenChuPhuongTien, maPhuongTien, ngayDangKy));
            IOPhuongTienFile.ghiGTKPTFile(DUONG_DAN_GDKPT, giayDangKyList);
        }

    }

    @Override
    public void xem() {
        List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();
        List<GiayDangKy> giayDangKyList = new ArrayList<>();
        try {
            phuongTienGiaoThongs.addAll(IOPhuongTienFile.docPhuongTienFile(DUONG_DAN_PHUONG_TIEN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (phuongTienGiaoThongs.isEmpty()) {
            System.out.println("Không tồn tại phương tiện để xem danh sách đăng ký");
        } else {

            try {
                giayDangKyList.addAll(IOPhuongTienFile.docGDKPTFile(DUONG_DAN_GDKPT));
            } catch (ParseException | NumberFormatException e) {
                e.printStackTrace();
            }

            if (giayDangKyList.isEmpty()) {
                System.out.println("Không tồn tại giấy đăng ký phương tiện");
            } else {
                for (GiayDangKy giayDangKy:giayDangKyList){
                    System.out.print(giayDangKy+"  ");
                    for (PhuongTienGiaoThong phuongTienGiaoThong:phuongTienGiaoThongs){
                        if(phuongTienGiaoThong.getMaPhuongTien().equals(giayDangKy.getMaPhuongTien()))
                            System.out.println(phuongTienGiaoThong);
                        break;
                    }
                }

            }
        }

    }

    @Override
    public void huy() {
        List<GiayDangKy> giayDangKyList = new ArrayList<>();
        try {
            giayDangKyList.addAll(IOPhuongTienFile.docGDKPTFile(DUONG_DAN_GDKPT));
        } catch (ParseException | NumberFormatException e) {
            e.printStackTrace();
        }

        if (giayDangKyList.isEmpty()) {
            System.out.println("Không tồn tại giấy đăng ký phương tiện");
        } else {
            String soDangKy = InputUtil.nhapMaSoDK("Nhập vào mã số đăng ký để xóa");
            for (GiayDangKy giayDangKy : giayDangKyList) {
                if (soDangKy.equals(giayDangKy.getSoDangKy())) {
                    System.out.println("Thông tin giấy đăng ký bạn muốn xóa");
                    System.out.println(giayDangKy);
                    if (InputUtil.getBoolean("chọn true khi bạn chắc chắn muốn xóa:")) {
                        giayDangKyList.remove(giayDangKy);
                        IOPhuongTienFile.ghiGTKPTFile(DUONG_DAN_GDKPT, giayDangKyList);
                    } else {
                        System.out.println("Bạn đã hủy xóa giáy đăng ký có số DK:" + soDangKy);
                        InputUtil.getString("Nhấn enter để quay lại menu chính");
                    }
                }
            }
        }
    }
}

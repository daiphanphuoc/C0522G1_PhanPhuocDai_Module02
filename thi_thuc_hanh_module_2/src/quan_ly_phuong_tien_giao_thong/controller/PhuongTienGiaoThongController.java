package quan_ly_phuong_tien_giao_thong.controller;

import quan_ly_phuong_tien_giao_thong.libs.InputUtil;
import quan_ly_phuong_tien_giao_thong.service.impl.GiayDangKyPhuongTienServiceImpl;

public class PhuongTienGiaoThongController {
    public static void mainMenu(){
        while (true){
            int choose= InputUtil.getInt("--Chương trình quản lý phương tiện giao thông--\n" +
                    "Chọn chức năng theo số để tiếp tục:\n" +
                    "1.Đăng ký phương tiên.\n" +
                    "2.Xem danh sách đăng ký phương tiên\n" +
                    "3.Hủy đăng ký phương tiện\n" +
                    "4.Thoát." );
            switch (choose){
                case 1:
                    GiayDangKyPhuongTienServiceImpl.getInstance().dangKy();
                    break;
                case 2:
                    GiayDangKyPhuongTienServiceImpl.getInstance().xem();
                    break;
                case 3:

                    GiayDangKyPhuongTienServiceImpl.getInstance().huy();
                    break;
                case 4:
                  System.exit(0);
            }
        }
    }
}

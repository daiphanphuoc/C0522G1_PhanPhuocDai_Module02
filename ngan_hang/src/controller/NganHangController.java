package controller;

import libs.InputUtil;
import service.impl.TaiKhoanServiceImpl;

public class NganHangController {
    public static void menu(){
        while (true){
            int choose= InputUtil.getInt("--Chương trình quản lý tài khoản ngân hàng--\n" +
                    "Chọn chức năng theo số để tiếp tục:\n" +
                    "1.Thêm mới.\n" +
                    "2.Xóa\n" +
                    "3.Xem danh sách các tài khoản ngân hàng\n" +
                    "4.Tìm kiến\n" +
                    "5.Thoát." );
            switch (choose){
                case 1:
                    TaiKhoanServiceImpl.getInstance().them();
                    break;
                case 2:
                    TaiKhoanServiceImpl.getInstance().xoa(InputUtil.getString("Nhập vào mã tài khoản cần xóa"));
                    break;
                case 3:
                    TaiKhoanServiceImpl.getInstance().hienThi();
                    break;
                case 4:
                    TaiKhoanServiceImpl.getInstance().timKiem(InputUtil.getString("Nhập vào thông tin cần tìm "));
                    break;
                case 5:System.exit(0);
            }
        }
    }
}

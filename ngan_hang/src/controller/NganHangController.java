package controller;

import libs.InputUtil;

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
                case 1:break;
                case 2:break;
                case 3:break;
                case 4:break;
                case 5:System.exit(0);
            }
        }
    }
}

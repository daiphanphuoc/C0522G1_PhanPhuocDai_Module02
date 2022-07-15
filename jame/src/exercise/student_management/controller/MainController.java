package exercise.student_management.controller;

import java.util.Scanner;

public class MainController {
    public static void mainMenu(){
        Scanner sc =new Scanner(System.in);
        NewController newController=new NewController();
        DisplayController displayController=new DisplayController();
        DeleteController deleteController=new DeleteController();
        do {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--\n"+
                    "1.Thêm mới\n"+
                    "2.Xóa\n"+
                    "3. Hiển thị danh sách\n"+
                    "4.Thoát");
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:{
                    newController.menuAdd();
                    break;
                }
                case 2:{
                    deleteController.deleteMenu();
                    break;
                }
                case 3:{
                    displayController.menuDisplay();
                    break;
                }
                case 4:{

                    System.exit(1);
                }
            }
        }while (true);

    }
}
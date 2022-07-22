package exercise.student_management_file.controller;

import java.util.Scanner;

public class MainController {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--\n" +
                    "1.Quản lý Sinh viên\n" +
                    "2.Quản lý Giảng viên\n" +
                    "3.Thoát\n");
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1: {
                    (new StudentController()).menuStudent();
                    break;
                }
                case 2: {
                   (new TeacherController()).menuTeacher();
                    break;
                }
                case 3: {
                    System.exit(1);
                }
            }
        } while (true);

    }
}

package exercise.student_management_file.controller;

import java.util.Scanner;

public class MainController {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        NewController newController = new NewController();
        DisplayController displayController = new DisplayController();
        DeleteController deleteController = new DeleteController();
        SearchController searchController = new SearchController();
        SortController sortController = new SortController();
        do {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--\n" +
                    "1.Quản lý Sinh viên\n" +
                    "2.Quản lý Giảng viên\n" +
                    "3.Thoát\n");
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1: {
                    newController.menuAdd();
                    break;
                }
                case 2: {
                    deleteController.deleteMenu();
                    break;
                }
                case 3: {
                    displayController.menuDisplay();
                    break;
                }
                case 4: {
                    searchController.menuSearch();
                    break;
                }
                case 5: {
                    sortController.sort();
                    break;
                }
                case 6: {

                    System.exit(1);
                }
            }
        } while (true);

    }
}

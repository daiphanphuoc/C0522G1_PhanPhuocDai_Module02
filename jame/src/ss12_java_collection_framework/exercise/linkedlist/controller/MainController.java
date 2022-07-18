package ss12_java_collection_framework.exercise.linkedlist.controller;

import ss12_java_collection_framework.exercise.linkedlist.model.Product;
import ss12_java_collection_framework.exercise.linkedlist.service.impl.ProductManagerService;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    ProductManagerService productManagerService = new ProductManagerService();

    public void mainMenu() {
        do {
            System.out.println("--------Menu-----------\n" +
                    "1.Thêm sản phẩm\n" +
                    "2.Xóa sản phẩm\n" +
                    "3.Sửa sản phẩm\n" +
                    "4.Hiển thị danh sách sản phẩm\n" +
                    "5.Sắp xếp tăng dần theo giá\n" +
                    "6.Sắp xếp giảm dần theo giá\n" +
                    "7.Tìm kiếm theo tên sản phẩm\n" +
                    "8.thoát.");
            System.out.println("Mơi chọn:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    productManagerService.add();
                    break;
                case 2:
                    System.out.println("Nhập vào mã sản phẩm  cần xóa ");
                    String id = sc.nextLine();
                    productManagerService.remove(id);
                    break;
                case 3:
                    System.out.println("Nhập vào mã sản phẩm  cần sửa ");
                    String idProduct = sc.nextLine();
                    productManagerService.update(idProduct);
                    break;
                case 4:
                    productManagerService.display();
                    break;
                case 5:
                    productManagerService.sort();
                    productManagerService.display();
                    break;
                case 6:
                    productManagerService.reverse();
                    productManagerService.display();
                    break;
                case 7:
                    System.out.println("Nhập vào tên sản phẩm cần tìm:");
                    String name = sc.nextLine();
                    ArrayList<Product> products = productManagerService.find(name);
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 8:
                    System.exit(1);
            }
        } while (true);

    }
}

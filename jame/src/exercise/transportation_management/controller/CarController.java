package exercise.transportation_management.controller;

import exercise.transportation_management.model.Car;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.impl.CarServiceImpl;

import java.util.Scanner;

public class CarController {

    public void menuCar() {
        CarServiceImpl carService = new CarServiceImpl();
        String id;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("---QUẢN LÝ XE Ô TÔ---\n" +
                    "1. Thêm mới." +
                    "2. Hiển thị." +
                    "3. Xóa." +
                    "4. Tìm kiếm." +
                    "5. Trở về menu chính.");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    carService.add();
                    break;
                case 2:
                    carService.display();
                    break;
                case 3:
                     id =carService.getSeaOfControl();
                    carService.delete(id);
                    break;
                case 4:
                     id =carService.getSeaOfControl();
                     Transport car=carService.find(id);
                    if( car instanceof Car){

                        System.out.println("tìm thấy:" + car);
                    }else{
                        System.out.println("không tìm thấy");
                    }
                    break;
                case 5:
                    return;

            }
        } while (true);
    }
}

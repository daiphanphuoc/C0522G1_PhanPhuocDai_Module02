package exercise.transportation_management.controller;

import exercise.student_management.controller.DeleteController;
import exercise.student_management.controller.DisplayController;
import exercise.student_management.controller.NewController;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.impl.TransportServiceImpl;

import java.util.Scanner;

public class MainController {

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        CarController carController = new CarController();
        MotorcycleController motorcycleController = new MotorcycleController();
        TruckController truckController = new TruckController();
        TransportController transportController = new TransportController();
        TransportServiceImpl transportService =new TransportServiceImpl();
        do {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG--\n" +
                    "1.Quản lý xe ô tô\n" +
                    "2.Quản lý xe tải\n" +
                    "3.Quản lý xe mô tô\n" +
                    "4.Tìm kiếm theo biển kiểm soát\n" +
                    "5.Thoát");
            System.out.println("chọn chức năng:");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1: {
                    carController.menuCar();
                    break;
                }
                case 2: {
                    truckController.menuTruck();
                    break;
                }
                case 3: {
                    motorcycleController.menuMotorcycle();
                    break;
                }
                case 4: {
                    String id=transportService.getSeaOfControl();
                    Transport transport=transportService.find(id);
                    if(transport!=null){
                        System.out.println("Tìm thấy: "+transport);
                    }else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 5: {

                    System.exit(1);
                }
            }
        } while (true);

    }
}

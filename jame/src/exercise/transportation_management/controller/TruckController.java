package exercise.transportation_management.controller;

import exercise.transportation_management.model.Car;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.impl.CarServiceImpl;
import exercise.transportation_management.service.impl.TruckServiceImpl;

import java.util.Scanner;

public class TruckController {

    public void menuTruck() {
        TruckServiceImpl truckService = new TruckServiceImpl();

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("---QUẢN LÝ XE TẢI---\n" +
                    "1. Thêm mới." +
                    "2. Hiển thị." +
                    "3. Xóa." +
                    "4. Tìm kiếm." +
                    "5. Trở về menu chính.");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    truckService.add();
                    break;
                case 2:
                    truckService.display();
                    break;
                case 3:
                    String id =truckService.getSeaOfControl();
                    truckService.delete(id);
                    break;
                case 4:
                    id =truckService.getSeaOfControl();
                    Transport truck=truckService.find(id);
                    if( truck instanceof Car){

                        System.out.println("tìm thấy:" + truck);
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

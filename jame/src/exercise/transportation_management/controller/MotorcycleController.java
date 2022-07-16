package exercise.transportation_management.controller;

import exercise.transportation_management.model.Car;
import exercise.transportation_management.model.Motorcycle;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.MotorcycleService;
import exercise.transportation_management.service.impl.MotorcycleServiceImpl;
import exercise.transportation_management.service.impl.TransportServiceImpl;

import java.util.Scanner;

public class MotorcycleController {
    Scanner scanner=new Scanner(System.in);
    MotorcycleServiceImpl motorcycleService=new MotorcycleServiceImpl();
    TransportServiceImpl transportService=new TransportServiceImpl();
    public void menuMotorcycle() {
        do {
            System.out.println("\n======= QUẢN LÝ XE MÁY =======\n" +
                    "1. Thêm mới xe máy \n" +
                    "2. Xóa xe máy \n" +
                    "3. Xem danh sách xe máy \n" +
                    "4. Tìm theo biển kiểm soát \n" +
                    "5. Quay về menu chính.\n ");
            System.out.println("Mời chọn chức năng: ");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    motorcycleService.add();
                    break;
                case 2:
                    String id=transportService.getSeaOfControl();
                    motorcycleService.delete(id);
                    break;
                case 3:
                    motorcycleService.display();
                    break;
                case 4:
                    id =motorcycleService.getSeaOfControl();
                    Transport moto=motorcycleService.find(id);
                    if( moto instanceof Motorcycle){

                        System.out.println("tìm thấy:" + moto);
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

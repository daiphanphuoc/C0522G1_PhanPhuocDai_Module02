package exercise.transportation_management.service.impl;


import exercise.transportation_management.model.Car;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.CarService;

import java.util.Scanner;

public class CarServiceImpl extends TransportServiceImpl implements CarService {
    Scanner sc = new Scanner(System.in);

    public Car createCar() {
        System.out.print("Nhập vào biển kiểm soát:");
        String id = sc.nextLine();

        System.out.print("Nhập vào Hãng sản xuất:");
        String manufactureName = sc.nextLine();

        System.out.print("Nhập vào năm sản xuất:");
        String year = sc.nextLine();

        System.out.print("Nhập vào chủ sở hữu:");
        String name = sc.nextLine();

        System.out.print("Nhập vào  số lượng ghế ngồi:");
        int seats = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập vào loại xe(du lịch/ khách):");
        String type = sc.nextLine();


        return new Car(id, manufactureName, year, name, seats, type);
    }



    @Override
    public void add() {
        ServiceImpl.transportList.add(createCar());
    }

    @Override
    public void display() {
        for (Transport transport: ServiceImpl.transportList ) {
            if(transport instanceof Car){
                System.out.println(transport);
            }
        }
    }
}

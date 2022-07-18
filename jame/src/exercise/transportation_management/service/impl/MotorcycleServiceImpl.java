package exercise.transportation_management.service.impl;

import exercise.transportation_management.model.Motorcycle;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.MotorcycleService;

public class MotorcycleServiceImpl extends TransportServiceImpl implements MotorcycleService {

    public Motorcycle createMotorcycle() {
        System.out.print("Nhập vào biển kiểm soát:");
        String id = sc.nextLine();

        System.out.print("Nhập vào Hãng sản xuất:");
        String manufactureName = sc.nextLine();

        System.out.print("Nhập vào năm sản xuất:");
        String year = sc.nextLine();


        System.out.print("Nhập vào chủ sở hữu:");
        String name = sc.nextLine();

        System.out.print("Nhập vào công suất:");
        String wattage = sc.nextLine();

        return new Motorcycle(id, manufactureName, year, name, wattage);
    }


    @Override
    public void add() {
        DataServiceImpl.transportList.add(createMotorcycle());
    }

    @Override
    public void display() {
        for (Transport transport : DataServiceImpl.transportList) {
            if (transport instanceof Motorcycle) {
                System.out.println(transport);
            }
        }
    }
}

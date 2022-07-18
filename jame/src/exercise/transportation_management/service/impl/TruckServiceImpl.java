package exercise.transportation_management.service.impl;

import exercise.transportation_management.model.Transport;
import exercise.transportation_management.model.Truck;
import exercise.transportation_management.service.TruckService;

public class TruckServiceImpl extends TransportServiceImpl implements TruckService {

    public Truck createTruck() {
        System.out.print("Nhập vào biển kiểm soát:");
        String id = sc.nextLine();

        System.out.print("Nhập vào Hãng sản xuất:");
        String manufactureName = sc.nextLine();

        System.out.print("Nhập vào năm sản xuất:");
        String year = sc.nextLine();


        System.out.print("Nhập vào chủ sở hữu:");
        String name = sc.nextLine();

        System.out.print("Nhập vào trọng tải:");
        double tonnage = Double.parseDouble(sc.nextLine());

        return new Truck(id, manufactureName, year, name, tonnage);
    }

    @Override
    public void add() {
        DataServiceImpl.transportList.add(createTruck());
    }

    @Override
    public void display() {

        for (Transport transport : DataServiceImpl.transportList) {
            if (transport instanceof Truck) {
                System.out.println(transport);
            }
        }
    }
}

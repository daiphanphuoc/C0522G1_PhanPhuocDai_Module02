package exercise.transportation_management.service.impl;

import exercise.student_management.service.impl.DataService;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.service.TransportService;

import java.util.Scanner;

public class TransportServiceImpl implements TransportService {

    Scanner sc = new Scanner(System.in);

    public String getSeaOfControl() {
        System.out.print("Nhập vào biển kiểm soát:");
        String seaOfControl = sc.nextLine();
        return seaOfControl;
    }


    @Override
    public void delete(String id) {
        for (Transport transport : ServiceImpl.transportList) {
            if (id.equals(transport.getSeaOfControl())) {
                System.out.println("Bạn chắc chắn xóa 1.yes:" + transport);
                int isRemove = Integer.parseInt(sc.nextLine());

                if (isRemove == 1) {
                    ServiceImpl.transportList.remove(transport);
                    System.out.println("Bạn đã xóa thành công!");
                }

                break;

            }
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {
        for (Transport transport : ServiceImpl.transportList) {
            System.out.println(transport);
        }
    }

    public Transport find(String id){
        for (Transport transport : ServiceImpl.transportList) {
            if (id.equals(transport.getSeaOfControl())){
                return transport;
            }
        }
        return null;
    }
}

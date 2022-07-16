package exercise.transportation_management.service.impl;

import exercise.transportation_management.model.Car;
import exercise.transportation_management.model.Motorcycle;
import exercise.transportation_management.model.Transport;
import exercise.transportation_management.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl {
    public static List<Transport> transportList = new ArrayList<>();

    static {

        transportList.add(new Car("92-D1 04-445", "Yamaha", "2011", "ÂN", 4, "Du lịch"));
        transportList.add(new Car("92-D1 08-888", "Yamaha", "2021", "ÂN", 4, "Du lịch"));
        transportList.add(new Car("92-D1 04-444", "Honda", "2001", "ÂN", 4, "Du lịch"));
        transportList.add(new Motorcycle("92-D1 05-555", "Honda", "2001", "ÂN", "1000cc"));
        transportList.add(new Motorcycle("92-D1 66-666", "Yamaha", "2001", "ÂN", "100cc"));
        transportList.add(new Motorcycle("92-D1 44-444", "Yamaha", "2001", "ÂN", "120cc"));
        transportList.add(new Truck("43-D1 04-444", "Honda", "2001", "ÂN", 5));
        transportList.add(new Truck("43-D1 00-111", "Yamaha", "2001", "ÂN", 4));
        transportList.add(new Truck("43-D1 04-666", "Honda", "2001", "ÂN", 20));

    }
}

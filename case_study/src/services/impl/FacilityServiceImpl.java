package services.impl;


import _exception.facility.IDFacilityException;
import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import org.jetbrains.annotations.NotNull;
import services.FacilityService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static libs.io_file.IOFacilityUtil.readFacilityFile;
import static libs.io_file.IOFacilityUtil.writeFacilityFile;
import static libs.InputFacilityUtil.*;
import static libs.InputUtil.getBoolean;
import static libs.InputUtil.getString;

public class FacilityServiceImpl implements FacilityService<Facility> {
    private static final String PATH_FACILITY = "case_study/src/data/facility.csv";
    private static FacilityServiceImpl facilityService;

    private FacilityServiceImpl() {
    }

    public static synchronized FacilityServiceImpl getInstance() {
        if (facilityService == null) {
            facilityService = new FacilityServiceImpl();
        }
        return facilityService;
    }

    @Override
    public void add() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        String id;
        while (true) {
            try {
                id = inputIDFacility("Mời bạn nhập vào id dịch vụ:");
                for (Facility facility : facilities.keySet()) {
                    if (facility.getIDFacility().equals(id)) {
                        throw new IDFacilityException("Trùng mã dịch vụ");
                    }
                }

                facilities.put(createFacility(id), 0);
                writeFacilityFile(PATH_FACILITY, facilities);
                break;
            } catch (IDFacilityException e) {
                e.printStackTrace();
            }
        }

        // Facility facility = createFacility();
    }




    private Facility createFacility(@NotNull String iDFacility) {
        String choose = iDFacility.substring(0, 4);
        Facility facility;
        switch (choose) {
            case "SVVL":
                System.out.println("Nhập thông tin dịch vụ Villa:");
                facility = createVilla(iDFacility);
                return facility;
            case "SVHO":
                System.out.println("Nhập thông tin dịch vụ House:");
                facility = createHouse(iDFacility);
                return facility;
            default:
                System.out.println("Nhập thông tin dịch vụ Room:");
                facility = createRoom(iDFacility);
                return facility;
        }
    }


    private @NotNull House createHouse(String iDFacility) {

        String nameFacility = inputString("Nhập vào tên dịch vụ:");

        double leasedArea = inputArea("Nhập vào diện tích sử dụng:");

        double rentalCosts = inputRentalCosts("Nhập vào chi phí thuê:");

        int maxPerson = inputMaxPerson("Nhập vào số lượng người tối đa:");

        String rentalType = inputString("Nhập vào kiểu thuê:");

        String room = inputString("Nhập vào tiêu chuẩn phòng:");

        int floor = inputFloor("Nhập vào số tầng:");

        return new House(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, room, floor);
    }

    private @NotNull Villa createVilla(String iDFacility) {

        String nameFacility = inputString("Nhập vào tên dịch vụ:");

        double leasedArea = inputArea("Nhập vào diện tích sử dụng:");

        double rentalCosts = inputRentalCosts("Nhập vào chi phí thuê:");

        int maxPerson = inputMaxPerson("Nhập vào số lượng người tối đa:");

        String rentalType = inputString("Nhập vào kiểu thuê:");

        String room = inputString("Nhập vào tiêu chuẩn phòng:");

        int floor = inputFloor("Nhập vào số tầng:");

        double areaPool = inputArea("Nhập vào diện tích hồ bơi:");

        return new Villa(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, room, floor, areaPool);
    }


    private @NotNull Room createRoom(String iDFacility) {
        String nameFacility = inputString("Nhập vào tên dịch vụ:");

        double leasedArea = inputArea("Nhập vào diện tích sử dụng:");

        double rentalCosts = inputRentalCosts("Nhập vào chi phí thuê:");

        int maxPerson = inputMaxPerson("Nhập vào số lượng người tối đa:");

        String rentalType = inputString("Nhập vào kiểu thuê:");

        String free = getString("Nhập vào dịch vụ miễn phí đi kèm:");

        return new Room(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, free);
    }

    @Override
    public void display() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        System.out.println("Danh sách dịch vụ:");
        for (Facility facility : facilities.keySet()) {
            System.out.println(facility);
        }
       // writeFacilityFile(PATH_FACILITY,facilities);
    }

    public void displayMaintenance() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) == 5)
                System.out.println(facility);
        }
    }

    @Override
    public void update(String iDFacility) {
        Facility facility = find(getString(iDFacility));
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        if (facility != null) {
            facility = createFacility(iDFacility);
            facilities.put(facility, 0);
            writeFacilityFile(PATH_FACILITY, facilities);
            System.out.println("Cập nhật thông tin thành công");
        } else {
            System.err.println("không tồn tại dịch vụ nào có id = " + iDFacility);
        }

    }

    @Override
    public void remove(String iDFacility) {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        Facility facility = find(iDFacility);
        if (facility != null && getBoolean("Bạn chắc chắn muốn xóa--> nhập true")) {
            facilities.remove(facility);
            writeFacilityFile(PATH_FACILITY, facilities);
            System.out.println("Xóa thành công.");
        } else {
            System.err.println("không tồn tại dịch vụ có id= " + iDFacility);
        }
    }

    @Override
    public Facility find(String iDFacility) {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        for (Facility facility : facilities.keySet()) {
            if (facility.getIDFacility().equals(iDFacility)) {
                return facility;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Facility> search(@NotNull String name) {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        String[] arrName = name.toLowerCase().trim().split(" ");
        ArrayList<Facility> facilityArrayList = new ArrayList<>();

        for (Facility facility : facilities.keySet()) {
            for (String s : arrName) {
                if (facility.getNameFacility().toLowerCase().contains(s)) {
                    facilityArrayList.add(facility);
                    break;
                }
            }
        }

        return facilityArrayList;
    }
}

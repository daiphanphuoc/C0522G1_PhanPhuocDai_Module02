package services.impl;


import _exception.IDFacilityException;
import libs.InputUtil;
import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import services.FacilityService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static libs.IOFileUtil.readFacilityFile;
import static libs.IOFileUtil.writeFacilityFile;
import static libs.InputUtil.*;

public class FacilityServiceImpl implements FacilityService<Facility> {
    public static final String PATH_FACILITY = "case_study/src/data/facility.csv";
    private static final String[] TYPE_FACILITY = {"", "Vila", "House", "Room"};

    @Override
    public void add() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        String id;
        while (true) {
            try {
                id = getString("Mời bạn nhập vào id dịch vụ:");
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

    private Facility createFacility(String iDFacility) {
        int choose;
        do {
            /*System.out.println("Mời bạn chọn loại dịch vụ muốn thêm:");
            System.out.println("Nhập 1: Vila");
            System.out.println("Nhập 2: House");
            System.out.println("Nhập 3: Room");
            choose = getInt("Mời bạn chọn:");*/
            System.out.println(" Add new Facility Management: ");
            System.out.println("1\tAdd new Villa");
            System.out.println("2\tAdd new House");
            System.out.println("3\tAdd New Room");
            //System.out.println("4\tReturn main menu");

            choose = getInt("Enter choose:");
            if (choose < 1 || choose > 3) {
                System.err.println("Nhập sai, yêu cầu nhập lại.");
            }
        } while (choose < 1 || choose > 3);
        Facility facility;

        switch (choose) {
            case 1:
                facility = createVilla(iDFacility);
                return facility;
            case 2:
                facility = createHouse(iDFacility);
                return facility;
            default:
                facility = createRoom(iDFacility);
                return facility;
        }
    }

    @Contract(" -> new")
    private @NotNull House createHouse(String iDFacility) {

        String nameFacility = getString("Nhập vào tên dịch vụ:");
        double leasedArea = getDouble("Nhập vào diện tích sử dụng:");
        double rentalCosts = getDouble("Nhập vào chi phí thuê:");
        int maxPerson = getInt("Nhập vào số lượng người tối đa:");
        String rentalType = getString("Nhập vào kiểu thuê:");
        String room = getString("Nhập vào tiêu chuẩn phòng:");
        int floor = getInt("Nhập vào số tầng:");

        return new House(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, room, floor);
    }

    private @NotNull Villa createVilla(String iDFacility) {

        String nameFacility = getString("Nhập vào tên dịch vụ:");
        double leasedArea = getDouble("Nhập vào diện tích sử dụng:");
        double rentalCosts = getDouble("Nhập vào chi phí thuê:");
        int maxPerson = getInt("Nhập vào số lượng người tối đa:");
        String rentalType = getString("Nhập vào kiểu thuê:");
        String room = getString("Nhập vào tiêu chuẩn phòng:");
        int floor = getInt("Nhập vào số tầng:");
        double areaPool = getDouble("Nhập vào diện tích hồ bơi:");
        return new Villa(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, room, floor, areaPool);
    }

    @Contract(" -> new")
    private @NotNull Room createRoom(String iDFacility) {
        String nameFacility = getString("Nhập vào tên dịch vụ:");
        double leasedArea = getDouble("Nhập vào diện tích sử dụng:");
        double rentalCosts = getDouble("Nhập vào chi phí thuê:");
        int maxPerson = getInt("Nhập vào số lượng người tối đa:");
        String rentalType = getString("Nhập vào kiểu thuê:");
        String free = getString("Nhập vào dịch vụ miễn phí đi kèm:");
        return new Room(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, free);
    }

    @Override
    public void display() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        for (Facility facility : facilities.keySet()) {
            System.out.println(facility);
        }
    }

    public void displayMaintenance() {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) == 5)
                System.out.println(facility);
        }
    }

    @Override
    public void update(String id) {
        Facility facility = find(getString(id));
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        if (facility != null) {
            if (facility instanceof Villa) {
                facility = createVilla(id);
            } else if (facility instanceof House) {
                facility = createHouse(id);
            } else {
                facility = createRoom(id);
            }
            facilities.put(facility, 0);
            writeFacilityFile(PATH_FACILITY, facilities);
            System.out.println("Cập nhật thông tin thành công");
        } else {
            System.err.println("không tồn tại dịch vụ nào có id = " + id);
        }

    }

    @Override
    public void remove(String id) {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        Facility facility = find(id);
        if (facility != null && getBoolean("Bạn chắc chắn muốn xóa--> nhập true")) {
            facilities.remove(facility);
            writeFacilityFile(PATH_FACILITY, facilities);
            System.out.println("Xóa thành công.");
        } else {
            System.err.println("không tồn tại dịch vụ có id= " + id);
        }
    }

    @Override
    public Facility find(String id) {
        LinkedHashMap<Facility, Integer> facilities = readFacilityFile(PATH_FACILITY);
        for (Facility facility : facilities.keySet()) {
            if (facility.getIDFacility().equals(id)) {
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

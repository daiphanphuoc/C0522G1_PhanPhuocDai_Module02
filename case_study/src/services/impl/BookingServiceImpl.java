package services.impl;

import _exception.facility.IDBookingException;
import libs.InputUtil;
import libs.io_file.IOBookingUtil;
import libs.io_file.IOFacilityUtil;
import libs.io_file.IOPersonUtil;
import models.Booking;
import models.Path;
import models.facility.Facility;
import models.person.Customer;
import org.jetbrains.annotations.NotNull;
import services.BookingService;

import java.text.ParseException;
import java.util.*;

import static libs.InputBookingUtil.inputIDBooking;
import static libs.InputFacilityUtil.inputIDFacility;
import static libs.InputPersonUtil.inputIDCustomer;
import static libs.InputUtil.getDate;
import static libs.InputUtil.getInt;

public class BookingServiceImpl implements BookingService<Booking> {
    private static BookingServiceImpl bookingService;
    private static Queue<Booking> bookingQueue = new LinkedList<>();

    private BookingServiceImpl() {
    }

    public static synchronized BookingServiceImpl getInstance() {
        if (bookingService == null) {
            bookingService = new BookingServiceImpl();
        }
        return bookingService;
    }

    public static synchronized Queue<Booking> getBookingQueue() {
        return bookingQueue;
    }

    public static synchronized void setBookingQueue() {
        if (!bookingQueue.isEmpty()) {
            bookingQueue.poll();
        }
    }

    @Override
    public void add() {
        String iDCustomer = isCustomer("Mã khách hàng:");
        Set<Booking> bookings = new TreeSet<>();
        try {
            bookings = IOBookingUtil.readBookingFile(Path.BOOKING.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String iDBooking;
        while (true) {
            try {
                iDBooking = inputIDBooking("Nhập vào mã booking:");
                assert bookings != null;
                for (Booking booking : bookings) {
                    if (booking.getIDBooking().equals(iDBooking)) {
                        throw new IDBookingException("Trùng mã booking");
                    }
                }
                break;
            } catch (IDBookingException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        Booking booking = creatBooking(iDBooking, iDCustomer);
        if (booking != null) {
            bookings.add(booking);
            IOBookingUtil.writeBookingFile(Path.BOOKING.getPath(), bookings);
            LinkedHashMap<Facility, Integer> facilityIntMap;
            facilityIntMap = IOFacilityUtil.readFacilityFile(Path.FACILITY.getPath());
            for (Facility facility : facilityIntMap.keySet()) {
                if (facility.getIDFacility().equals(booking.getIDFacility())) {
                    facilityIntMap.put(facility, facilityIntMap.get(facility) + 1);
                }
            }

            if (booking.getIDFacility().contains("SVVl") || booking.getIDFacility().contains("SVHO")) {
                bookingQueue.offer(booking);
            }
        } else {
            System.out.println("Không tồn tại dịch vụ.");
        }
    }

    @NotNull
    private String isCustomer(String target) {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = IOPersonUtil.readCustomerFile(Path.CUSTOMER.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String iDCustomer;
        boolean isCustomer = false;
        while (true) {
            iDCustomer = inputIDCustomer(target);
            for (Customer customer : customers) {
                if (customer.getIDCustomer().equals(iDCustomer)) {
                    isCustomer = true;
                    break;
                }
            }

            if (isCustomer) {
                break;
            } else {
                System.out.println("Chưa gia nhập thành viên hoặc nhập không đúng mã khách hàng");

                int register = getInt("Nếu bạn chưa gia nhập thành viên, vui lòng đăng ký." +
                        " chọn 1 để đăng ký.");
                if (register == 1) {
                    CustomerServiceImpl.getInstance().add(iDCustomer);
                    break;
                }
            }
        }
        return iDCustomer;
    }

    public Booking creatBooking(String iDBooking, String iDCustomer) {
        LinkedHashMap<Facility, Integer> facilityIntMap;
        facilityIntMap = IOFacilityUtil.readFacilityFile(Path.FACILITY.getPath());
        (FacilityServiceImpl.getInstance()).display();
        String iDFacility;
        Facility temp = null;
        if (!facilityIntMap.isEmpty()) {
            FacilityServiceImpl.getInstance().display();
            while (true) {
                iDFacility = inputIDFacility("Chọn mã dịch vụ");
                for (Facility facility : facilityIntMap.keySet()) {
                    if (facility.getIDFacility().equals(iDFacility)) {
                        temp = facility;
                        break;
                    }
                }
                if (temp == null) {
                    System.out.println("Không tồn tại  dịch vụ có mã: " + iDFacility);
                    System.out.println("Chọn lại:");
                } else {
                    break;
                }
            }
            Date begin = getDate("Nhập vào ngày bắt đầu:");

            Date end = getDate("Nhập vào ngày kết thúc:");
            String nameFacility;
            nameFacility = temp.getNameFacility();
            return new Booking(iDBooking, begin, end, iDCustomer, nameFacility, iDFacility);
        }
        return null;
    }

    @Override
    public void display() {
        Set<Booking> bookings = new TreeSet<>();
        try {
            bookings.addAll(Objects.requireNonNull(IOBookingUtil.readBookingFile(Path.BOOKING.getPath())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<Booking> arrBooking = new ArrayList<>();
        for (Booking booking : bookings) {
            arrBooking.add(booking);
        }
        Collections.sort(arrBooking, new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                if (o1.getBegin().after(o2.getBegin())) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
        for (Booking booking : arrBooking) {
            System.out.println(booking);
        }

    }

    @Override
    public void update(String id) {
        Booking booking = find(id);
        if (booking != null) {
            booking.setBegin(InputUtil.getDate("Nhập vào ngày bắt đầu mới :"));
            booking.setEnd(InputUtil.getDate("Nhập vào ngày kết thúc mới :"));
            Set<Booking> bookings = new TreeSet<>();
            try {
                bookings = IOBookingUtil.readBookingFile(Path.BOOKING.getPath());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            bookings.add(booking);
            IOBookingUtil.writeBookingFile(Path.BOOKING.getPath(), bookings);
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Không tìm thấy ");
        }

    }

    @Override
    public void remove(String id) {
        Booking booking = find(id);
        if (booking != null) {
            if (booking.getBegin().after(new Date())) {
                Set<Booking> bookings = new TreeSet<>();
                try {
                    bookings.addAll(Objects.requireNonNull(IOBookingUtil.readBookingFile(Path.BOOKING.getPath())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(booking);
                if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa, xin nhấn true:")) {
                    if (booking.getIDFacility().contains("SVVL") || booking.getIDFacility().contains("SVHO")) {
                        if (ContactServiceImpl.getInstance().remove(booking)) {
                            bookings.remove(booking);
                            IOBookingUtil.writeBookingFile(Path.BOOKING.getPath(), bookings);
                            System.out.println("Xóa thành công.");
                            LinkedHashMap<Facility, Integer> facilities = IOFacilityUtil.readFacilityFile(Path.FACILITY.getPath());
                            Facility facility = FacilityServiceImpl.getInstance().find(booking.getIDFacility());
                            facilities.put(facility, facilities.get(facility) - 1);
                            IOFacilityUtil.writeFacilityFile(Path.FACILITY.getPath(), facilities);
                            return;
                        }
                        System.out.println("Bạn đã không xóa hợp đồng, không thể xóa booking.");
                    }
                }
                System.out.println("Bạn lựa chọn không tiếp tục xóa");
            }
            System.out.println("Đã quá hạn dc hủy booking.");
        }
        System.out.println("Không tìm thấy");

    }

    @Override
    public Booking find(String id) {
        Set<Booking> bookings = new TreeSet<>();
        try {
            bookings.addAll(Objects.requireNonNull(IOBookingUtil.readBookingFile(Path.BOOKING.getPath())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Booking booking : bookings) {
            if (booking.getIDBooking().equals(id)) {
                return booking;
            }
        }
        return null;
    }


}

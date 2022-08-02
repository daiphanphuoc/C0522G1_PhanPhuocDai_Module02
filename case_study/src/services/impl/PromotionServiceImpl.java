package services.impl;

import libs.InputUtil;
import libs.io_file.IOBookingUtil;
import models.Booking;
import models.Path;
import models.person.Customer;

import java.text.ParseException;
import java.util.*;

public class PromotionServiceImpl {
    private static PromotionServiceImpl promotionService;

    private PromotionServiceImpl() {
    }

    public static PromotionServiceImpl getInstance(){
        if(promotionService==null){
            promotionService=new PromotionServiceImpl();
        }
        return promotionService;
    }

    public void display(int year) {
        Set<Booking> bookings = new TreeSet<>();
        try {
            bookings.addAll(IOBookingUtil.readBookingFile(Path.BOOKING.getPath()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Set<Customer> customers = new LinkedHashSet<>();
        if (!bookings.isEmpty()) {
            for (Booking booking : bookings) {
                System.out.println(booking.getBegin().getYear());
                if (booking.getBegin().getYear() == year-1900) {
                    customers.add(CustomerServiceImpl.getInstance().find(booking.getIDCustomer()));
                }
            }

            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }


    }


    public void voucher() {
        int voucher10 = InputUtil.getInt("Nhập vào số lượng voucher khuyến mãi 10%");
        int voucher20 = InputUtil.getInt("Nhập vào số lượng voucher khuyến mãi 20%");
        int voucher50 = InputUtil.getInt("Nhập vào số lượng voucher khuyến mãi 50%");

        Set<Booking> bookings = new TreeSet<>();
        try {
            bookings.addAll(IOBookingUtil.readBookingFile(Path.BOOKING.getPath()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Stack<Customer> customers = new Stack<>();
        if (!bookings.isEmpty()) {
            for (Booking booking : bookings) {
                if (booking.getBegin().getYear() == (new Date().getYear()) && booking.getBegin().getMonth() == (new Date().getMonth())) {
                    customers.add(CustomerServiceImpl.getInstance().find(booking.getIDCustomer()));
                }
            }

            while (voucher10 > 0 && !customers.isEmpty()){
                System.out.println(customers.pop().getName()+ "được tặng 1 voucher 10%");
            }
            while (voucher20 > 0 && !customers.isEmpty()){
                System.out.println(customers.pop().getName()+ "được tặng 1 voucher 20%");
            }
            while (voucher50 > 0 && !customers.isEmpty()){
                System.out.println(customers.pop().getName()+ "được tặng 1 voucher 50%");
            }

        }
    }
}

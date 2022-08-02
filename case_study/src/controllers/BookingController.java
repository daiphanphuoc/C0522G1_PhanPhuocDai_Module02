package controllers;

import libs.InputBookingUtil;
import libs.InputUtil;
import services.impl.BookingServiceImpl;
import services.impl.ContactServiceImpl;

public class BookingController {
    private static BookingController bookingController;

    public static synchronized BookingController getInstance() {
        if (bookingController == null) {
            bookingController = new BookingController();

        }
        return bookingController;
    }

    public void displayBookingManagementMenu() {
        int choice;
        do {

            System.out.println("Booking  Management: ");
            System.out.println("1\tDisplay list booking");
            System.out.println("2\tAdd new booking");
            System.out.println("3.\tCreate new constracts");
            System.out.println("4.\tDisplay list contracts");
            System.out.println("5.\tEdit contracts");
            System.out.println("6.\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:
                    BookingServiceImpl.getInstance().display();
                    break;
                case 2:
                    BookingServiceImpl.getInstance().add();
                    break;
                case 3:
                    ContactServiceImpl.getInstance().add(BookingServiceImpl.getBookingQueue());
                    break;
                case 4:
                    ContactServiceImpl.getInstance().display();
                    break;

                case 5:
                    String id = InputBookingUtil.inputIDBooking(
                            "Nhập vào số hợp đồng cần  thay đổi thông tin hợp đồng");
                    BookingServiceImpl.getInstance().update(id);
                    break;
                case 6:
                    return;
            }
        } while (true);

    }
}

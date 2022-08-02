package controllers;

import libs.InputUtil;
import services.impl.PromotionServiceImpl;

public class FuramaController {

    public static void displayMainMenu() {

        int choice;
        do {

            System.out.println("Main Menu: ");
            System.out.println("1.\tEmployee Management:");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:
                    EmployeeController.displayEmployeeManagementMenu();
                    break;
                case 2:
                    CustomerController.displayCustomerManagementMenu();
                    break;
                case 3:
                    FacilityController.displayFacilityManagementMenu();
                    break;
                case 4:
                    BookingController.getInstance().displayBookingManagementMenu();
                    break;
                case 5:
                    PromotionController.displayPromotionManagementMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không đúng.");
            }
        } while (true);
    }




}

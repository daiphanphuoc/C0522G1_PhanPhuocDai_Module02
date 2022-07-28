package controllers;

import libs.InputUtil;

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
                    displayBookingManagementMenu();
                    break;
                case 5:
                    displayPromotionManagementMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không đúng.");
            }
        } while (true);
    }







    public static void displayBookingManagementMenu() {
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;

                case 5:
                    break;
                case 6:
                    return;
            }
        } while (true);

    }

    public static void displayPromotionManagementMenu() {
        int choice;
        do {

            System.out.println("Promotion  Management: ");
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3.\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    return;

            }
        } while (true);

    }


}

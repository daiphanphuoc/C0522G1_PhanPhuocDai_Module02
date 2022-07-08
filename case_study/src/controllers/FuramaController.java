package controllers;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        int choice;
        do {

            System.out.println("Menu: ");
            System.out.println("1.\tEmployee Management:");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayEmployeeManagementMenu();
                    break;
                case 2:
                    displayCustomerManagementMenu();
                    break;
                case 3:
                    displayFacilityManagementMenu();
                    break;
                case 4:
                    displayBookingManagementMenu();
                    break;
                case 5:
                    displayPromotionManagementMenu();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayEmployeeManagementMenu() {
        int choice;
        do {

            System.out.println("Employee Management: ");
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tEdit employee");
            System.out.println("4\tReturn main menu");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    return;


            }
        } while (true);

    }

    public static void displayCustomerManagementMenu() {
        int choice;
        do {

            System.out.println("Customer Management: ");
            System.out.println("1\tDisplay list customers");
            System.out.println("2\tAdd new customers");
            System.out.println("3\tEdit customers");
            System.out.println("4\tReturn main menu");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
            }
        } while (true);

    }

    public static void displayFacilityManagementMenu() {
        int choice;
        do {

            System.out.println("Facility  Management: ");
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
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

            choice = sc.nextInt();

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

            choice = sc.nextInt();

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

    public static void main(String[] args) {

    }
}

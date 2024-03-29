package controllers;

import libs.InputUtil;
import services.impl.FacilityServiceImpl;

public class FacilityController {
    public static void displayFacilityManagementMenu() {
        FacilityServiceImpl facilityService = FacilityServiceImpl.getInstance();
        int choice;
        do {

            System.out.println("Facility  Management: ");
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    facilityService.displayMaintenance();
                    break;
                case 4:
                    return;
            }
        } while (true);

    }

    /*public static void addNewFacility() {
        int choice;
        do {

            System.out.println(" Add new Facility Management: ");
            System.out.println("1\tAdd new Villa");
            System.out.println("2\tAdd new House");
            System.out.println("3\tAdd New Room");
            System.out.println("4\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

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

    }*/

}

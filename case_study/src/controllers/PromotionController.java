package controllers;

import libs.InputUtil;
import services.impl.PromotionServiceImpl;

public class PromotionController {

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
                    PromotionServiceImpl.getInstance().display(InputUtil.getInt("Nhập vào năm:"));
                    break;
                case 2:
                    PromotionServiceImpl.getInstance().voucher();
                    break;
                case 3:
                    return;

            }
        } while (true);

    }

}

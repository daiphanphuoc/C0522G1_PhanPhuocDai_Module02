package controllers;

import libs.InputUtil;
import services.impl.CustomerServiceImpl;

public class CustomerController {
    public static void displayCustomerManagementMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        int choice;
        do {

            System.out.println("Customer Management: ");
            System.out.println("1\tDisplay list customers");
            System.out.println("2\tAdd new customers");
            System.out.println("3\tEdit customers");
            System.out.println("4\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.update(InputUtil.getString(
                            "Nhập vào mã khách hàng muốn thay đồi thông tin:"));
                    break;
                case 4:
                    return;
            }
        } while (true);

    }
}

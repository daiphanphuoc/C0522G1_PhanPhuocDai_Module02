package controllers;

import libs.InputPersonUtil;
import libs.InputUtil;
import services.impl.EmployeeServiceImpl;

public class EmployeeController {
    public static void displayEmployeeManagementMenu() {
        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
        int choice;
        do {

            System.out.println("Employee Management: ");
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tEdit employee");
            System.out.println("4\tReturn main menu");

            choice = InputUtil.getInt("Enter choose:");

            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.update(InputPersonUtil.inputIDEmployee(
                            "Nhập vào id nhân viên cần edit"));
                    break;
                case 4:
                    return;


            }
        } while (true);

    }
}

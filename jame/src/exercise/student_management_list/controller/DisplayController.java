package exercise.student_management_list.controller;

import exercise.student_management_list.service.impl.PersonService;
import exercise.student_management_list.service.impl.StudentService;
import exercise.student_management_list.service.impl.TeacherService;

import java.util.Scanner;

public class DisplayController {
    public void menuDisplay() {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu thêm mới:\n" +
                    "1.Hiển thị danh sách sinh viên\n" +
                    "2.Hiển thị danh sách giáo viên\n" +
                    "3.Hiển thị danh sách giáo viên và sinh viên\n" +
                    "4.Trở về menu chính");

            System.out.println("Nhập vào lựa chọn:");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                case 1: {
                    StudentService studentService = new StudentService();
                    studentService.display();
                    break;
                }

                case 2: {
                    TeacherService teacherService = new TeacherService();
                    teacherService.display();
                    break;
                }

                case 3: {
                    PersonService personService = new PersonService();
                    personService.display();
                    break;
                }

                case 4:
                    return;
            }

        } while (true);


    }
}

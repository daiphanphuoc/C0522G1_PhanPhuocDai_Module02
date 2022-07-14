package exercise.student_management.controller;

import exercise.student_management.service.impl.PersonService;
import exercise.student_management.service.impl.StudentService;
import exercise.student_management.service.impl.TeacherService;

import java.util.Scanner;

public class DeleteController {
    Scanner sc = new Scanner(System.in);
    public void deleteMenu(){
        int choose;
        do {
            System.out.println("Menu thêm mới:\n" +
                    "1.Xóa sinh viên\n" +
                    "2.Xóa giáo viên\n" +
                    "3.Trở về menu chính\n");

            System.out.println("Nhập vào lựa chọn:");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                case 1: {
                    StudentService studentService = new StudentService();
                    studentService.delete(studentService.getID());
                    break;
                }

                case 2: {
                    TeacherService teacherService = new TeacherService();
                    teacherService.delete(teacherService.getID());
                    break;
                }

                case 3:
                    return;
            }

        } while (true);

    }


}

package exercise.student_management_file.controller;

import exercise.student_management_file.model.Student;
import exercise.student_management_file.service.impl.StudentService;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    public void menuStudent() {
        StudentService studentService = new StudentService();

        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu quản lý sinh viên:\n" +
                    "1.Thêm mới sinh viên\n" +
                    "2.Xóa sinh viên\n" +
                    "3.Tìm kiếm sinh viên theo id.\n" +
                    "4.Tìm kiếm sinh viên theo tên.\n" +
                    "5.Hiển thị danh sách sinh viên\n" +
                    "6.Sữa thông tin sinh viên.\n" +
                    "7.Sắp xếp danh sách.\n" +
                    "8.Trở về menu chính");

            choose = UtilInput.getInt("Nhập vào lựa chọn:");
            switch (choose) {

                case 1: {
                    studentService.add();
                    break;
                }
                case 2: {
                    studentService.delete(UtilInput.getString("Nhập vào mã sinh viên cần xóa:"));
                    break;

                }
                case 3: {
                    String id = UtilInput.getString("Nhập vào mã sinh viên cần tìm:");
                    Student student = studentService.find(id);
                    if(student!=null){
                        System.out.println(student);
                    }else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 4: {
                    String name = UtilInput.getString("Nhập vào tên sinh viên cần tìm:");
                    ArrayList<Student> students = studentService.search(name);
                    if (students.size() > 0) {
                        System.out.println("những sinh viên có liên quan với tên:" + name);
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 5: {
                    studentService.display();
                    break;
                }
                case 6: {
                    studentService.update(UtilInput.getString("Nhập vào mã sinh viên " +
                            "của sinh viên cần thay đổi thông tin:"));
                    break;
                }
                case 7: {
                    studentService.insertionSort();
                    break;
                }
                case 8:
                    return;
            }

        } while (true);

    }
}

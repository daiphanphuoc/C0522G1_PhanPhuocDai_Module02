package exercise.student_management_file.controller;

import exercise.student_management_file.model.Teacher;
import exercise.student_management_file.service.impl.TeacherService;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;

public class TeacherController {
    public void menuTeacher() {
        TeacherService teacherService = new TeacherService();

        int choose;
        do {
            System.out.println("Menu quản lý giảng viên:\n" +
                    "1.Thêm mới giảng viên\n" +
                    "2.Xóa giảng viên\n" +
                    "3.Tìm kiếm giảng viên theo id.\n" +
                    "4.Tìm kiếm giảng viên theo tên.\n" +
                    "5.Hiển thị danh sách giảng viên\n" +
                    "6.Thay đổi thông tin giảng viên.\n" +
                    "7.Sắp xếp danh sách.\n" +
                    "8.Trở về menu chính");

            choose = UtilInput.getInt("Nhập vào lựa chọn:");
            switch (choose) {

                case 1: {
                    teacherService.add();
                    break;
                }
                case 2: {
                    teacherService.delete(UtilInput.getString("Nhập vào mã giảng viên cần xóa:"));
                    break;
                }
                case 3: {
                    String id = UtilInput.getString("Nhập vào mã giảng viên cần tìm:");
                    Teacher teacher = teacherService.find(id);
                    if (teacher != null) {
                        System.out.println(teacher);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 4: {
                    String name = UtilInput.getString("Nhập vào tên giảng viên cần tìm:");
                    ArrayList<Teacher> teachers = teacherService.search(name);
                    if (teachers.size() > 0) {
                        System.out.println("những giảng viên có liên quan với tên:" + name);
                        for (Teacher teacher : teachers) {
                            System.out.println(teacher);
                        }
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                }
                case 5: {
                    teacherService.display();
                    break;
                }
                case 6: {
                    teacherService.update(UtilInput.getString("Nhập vào mã giảng viên " +
                            "của giảng viên cần thay đổi thông tin:"));
                    break;
                }
                case 7: {
                    teacherService.insertionSort();
                    System.out.println("Đã sắp xếp thành công");
                    break;
                }
                case 8:
                    return;
            }

        } while (true);

    }
}

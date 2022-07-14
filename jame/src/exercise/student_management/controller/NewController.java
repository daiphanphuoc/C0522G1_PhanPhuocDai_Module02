package exercise.student_management.controller;

import exercise.student_management.service.impl.StudentService;
import exercise.student_management.service.impl.TeacherService;

import java.util.Scanner;

public class NewController {
    public void menuAdd(){
        Scanner sc =new Scanner(System.in);
        int choose;
        do {
            System.out.println("Menu thêm mới:\n"+
                    "1.Thêm mới sinh viên\n"+
                    "2.Thêm mới giáo viên\n"+
                    "3.Trở về menu chính");
            System.out.println("Nhập vào lựa chọn:");
            choose= Integer.parseInt(sc.nextLine());
            switch (choose){

                case 1:{
                    StudentService studentService=new StudentService();
                    studentService.add();
                    break;
                }
                case 2:{
                    TeacherService teacherService=new TeacherService();
                    teacherService.add();
                    break;

                }
                case 3:return;
            }

        }while (true);


    }
}

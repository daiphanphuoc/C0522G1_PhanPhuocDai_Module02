package exercise.student_management.controller;

import exercise.student_management.model.Student;
import exercise.student_management.service.impl.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchController {
    public void menuSearch(){
        Scanner sc =new Scanner(System.in);
        StudentService studentService=new StudentService();
        do {
            System.out.println("------Menu Search-------\n" +
                    "1.Tìm kiếm sinh viên theo id\n" +
                    "2.Tìm kiếm sinh viên theo tên\n" +
                    "3.Trở về menu chính.\n");
            System.out.println("Mời chọn:");
            int choose= Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    System.out.println("Nhập vào mã sinh viên cần tìm");
                    String id =sc.nextLine();
                    System.out.println(studentService.find(id));

                    break;
                case 2:
                    System.out.println("Nhập vào tên sinh viên cần tìm");
                    String name =sc.nextLine();
                    ArrayList<Student> students=studentService.search(name);
                    System.out.println(students.size());
                    for (Student student:students){
                        System.out.println(student);
                    }
                    break;
                case 3:return;
            }
        }while(true);
    }
}

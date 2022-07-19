package exercise.student_management.controller;

import exercise.student_management.model.Student;
import exercise.student_management.model.Teacher;
import exercise.student_management.service.impl.StudentService;
import exercise.student_management.service.impl.TeacherService;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchController {
    public void menuSearch(){
        Scanner sc =new Scanner(System.in);
        StudentService studentService=new StudentService();
        TeacherService teacherService=new TeacherService();
        do {
            System.out.println("------Menu Search-------\n" +
                    "1.Tìm kiếm sinh viên theo id\n" +
                    "2.Tìm kiếm sinh viên theo tên\n" +
                    "3.Tìm kiếm giảng theo id\n" +
                    "4.Tìm kiếm giảng viên theo tên\n" +
                    "5.Trở về menu chính.\n");
            System.out.println("Mời chọn:");
            int choose= Integer.parseInt(sc.nextLine());
            String name;
            switch (choose){
                case 1:
                    System.out.println("Nhập vào mã sinh viên cần tìm");
                    String id =sc.nextLine();
                    System.out.println(studentService.find(id));

                    break;
                case 2:
                    System.out.println("Nhập vào tên sinh viên cần tìm");
                     name =sc.nextLine();
                    ArrayList<Student> students=studentService.search(name);

                    if(students.size()>0){
                        System.out.println("những sinh viên có liên quan với tên:" +name);
                        for (Student student:students){
                            System.out.println(student);
                        }
                    }else {
                        System.out.println("Không tìm thấy");
                    }

                    break;
                case 3:
                    System.out.println("Nhập vào mã giảng viên cần tìm");
                    String idTeach =sc.nextLine();
                    System.out.println(teacherService.find(idTeach));

                    break;
                case 4:
                    System.out.println("Nhập vào tên giảng viên cần tìm");
                     name =sc.nextLine();
                    ArrayList<Teacher> teachers=teacherService.search(name);

                    if(teachers.size()>0){
                        System.out.println("những giảng viên có liên quan với tên:" +name);
                        for (Teacher teacher:teachers){
                            System.out.println(teacher);
                        }
                    }else {
                        System.out.println("Không tìm thấy");
                    }

                    break;
                case 5:return;
            }
        }while(true);
    }
}

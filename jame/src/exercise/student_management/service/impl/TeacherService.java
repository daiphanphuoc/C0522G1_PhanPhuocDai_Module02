package exercise.student_management.service.impl;

import exercise.student_management.model.Person;
import exercise.student_management.model.Teacher;
import exercise.student_management.service.ITeacherService;

import java.util.Scanner;

public class TeacherService extends PersonService implements ITeacherService {
    private Scanner sc = new Scanner(System.in);

    public Teacher createTeacher() {
        System.out.print("Nhập vào mã:");
        String id = sc.nextLine();

        System.out.print("Nhập vào tên:");
        String name = sc.nextLine();

        System.out.print("Nhập vào ngày sinh:");
        String day = sc.nextLine();

        System.out.print("Nhập vào giới tính:(true/false)");
        boolean sex = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Nhập vào chuyên môn:");
        String specialize = sc.nextLine();

        return new Teacher(id,name,day,sex,specialize);
    }


    @Override
    public void add() {
        DataService.personList.add(createTeacher());
    }

    @Override
    public void display() {
        for (Person person:DataService.personList){
            if(person instanceof Teacher){
                System.out.println(person);
            }
        }
    }

}

package exercise.student_management.service.impl;

import exercise.student_management.model.Person;
import exercise.student_management.model.Student;
import exercise.student_management.service.IService;
import exercise.student_management.service.IStudentService;

import java.util.Scanner;

public class StudentService extends  PersonService implements  IStudentService {
    private Scanner sc = new Scanner(System.in);

    public Student createStudent() {
        System.out.print("Nhập vào mã:");
        String id = sc.nextLine();

        System.out.print("Nhập vào tên:");
        String name = sc.nextLine();

        System.out.print("Nhập vào ngày sinh:");
        String day = sc.nextLine();

        System.out.print("Nhập vào giới tính:(true/false)");
        boolean sex = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Nhập vào lớp:");
        String grade = sc.nextLine();

        System.out.print("Nhập vào điểm số:");
        double score = Double.parseDouble(sc.nextLine());

        return new Student(id, name, day, sex, grade, score);
    }

    @Override
    public void add() {
        DataService.personList.add(createStudent());
    }

    @Override
    public void display() {
        for (Person person : DataService.personList) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }


}

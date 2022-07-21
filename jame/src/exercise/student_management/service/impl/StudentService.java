package exercise.student_management.service.impl;

import exercise.student_management._exception.DuplicateIDException;
import exercise.student_management.model.Person;
import exercise.student_management.model.Student;
import exercise.student_management.service.IService;
import exercise.student_management.service.IStudentService;
import exercise.student_management.until.Until;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StudentService extends PersonService implements IStudentService {
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

        double score;
        while (true) {
            try {
                System.out.print("Nhập vào điểm số:");
                score = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập số! Nhập lại.");
                System.out.println(e.getMessage());
            }
        }


        return new Student(id, name, day, sex, grade, score);
    }

    @Override
    public void add() {
        Student student;
        while (true) {
            try {
                student = createStudent();

                for (Person person : DataService.personList) {
                    if (person.getID().equals(student.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.personList.add(student);
                break;

            } catch (DuplicateIDException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

    }

    @Override
    public void display() {
        for (Person person : DataService.personList) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public Student find(String id) {
        for (Person person : DataService.personList) {
            if (person instanceof Student) {
                if (person.getID().equals(id)) {
                    return (Student) person;
                }
            }
        }
        return null;
    }

    public ArrayList<Person> search(String name) {
        name = name.toLowerCase().trim();
        ArrayList<Person> students = new ArrayList<>();
        for (Person person : DataService.personList) {
            if (person instanceof Student) {
                if (Until.approximateComparison(person.getName(), name)) {
                    students.add(person);
                }
            }
        }
        // System.out.println(students.size());
        return students;
    }


}

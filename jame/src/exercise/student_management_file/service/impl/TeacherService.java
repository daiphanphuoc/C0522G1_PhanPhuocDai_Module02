package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Person;
import exercise.student_management_file.model.Teacher;
import exercise.student_management_file.service.ITeacherService;
import exercise.student_management_file.until.UtilFile;

import java.util.ArrayList;
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

        return new Teacher(id, name, day, sex, specialize);
    }


    @Override
    public void add() {
        Teacher teacher;
        while (true) {

            try {
                teacher = createTeacher();

                for (Person person : DataService.personList) {
                    if (person.getID().equals(teacher.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.personList.add(teacher);
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
            if (person instanceof Teacher) {
                System.out.println(person);
            }
        }
    }

    @Override
    public Teacher find(String id) {
        for (Person person : DataService.personList) {
            if (person instanceof Teacher) {
                if (person.getID().equals(id)) {
                    return (Teacher) person;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Person> search(String name) {
        name = name.toLowerCase().trim();
        ArrayList<Person> teachers = new ArrayList<>();
        for (Person person : DataService.personList) {
            if (person instanceof Teacher) {
                if (UtilFile.approximateComparison(person.getName(), name)) {
                    teachers.add(person);
                }
            }
        }
        // System.out.println(students.size());
        return teachers;
    }

}

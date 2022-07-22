package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Person;
import exercise.student_management_file.model.Student;
import exercise.student_management_file.service.IStudentService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService extends PersonService implements IStudentService {


    public Student createStudent() {
        String id = UtilInput.getString("Nhập vào mã:");

        String name = UtilInput.getString("Nhập vào tên:");

        String day = UtilInput.getString("Nhập vào ngày sinh:");

        boolean sex = UtilInput.getBoolean("Nhập vào giới tính:(true/false)");

        String grade = UtilInput.getString("Nhập vào lớp:");

        double score=UtilInput.getDouble("Nhập vào điểm số:");

        return new Student(id, name, day, sex, grade, score);
    }

    @Override
    public void add() {

        Student student;
        while (true) {
            try {
                student = createStudent();

                for (Person person : DataService.studentList) {
                    if (person.getID().equals(student.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.studentList.add(student);
                break;

            } catch (DuplicateIDException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

    }

    @Override
    public void display() {
        for (Person person : DataService.studentList) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public Student find(String id) {
        for (Person person : DataService.studentList) {
                if (person.getID().equals(id)) {
                    return (Student) person;
                }
            }
        return null;
    }

    public ArrayList<Person> search(String name) {
        name = name.toLowerCase().trim();
        ArrayList<Person> students = new ArrayList<>();
        for (Person person : DataService.studentList) {
            if (person instanceof Student) {
                if (UtilCompare.approximateComparison(person.getName(), name)) {
                    students.add(person);
                }
            }
        }
        // System.out.println(students.size());
        return students;
    }


}

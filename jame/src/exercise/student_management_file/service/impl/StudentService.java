package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Student;
import exercise.student_management_file.service.IStudentService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;

public class StudentService implements IStudentService {


    public Student createStudent() {
        String id = UtilInput.getString("Nhập vào mã:");

        String name = UtilInput.getString("Nhập vào tên:");

        String day = UtilInput.getString("Nhập vào ngày sinh:");

        boolean sex = UtilInput.getBoolean("Nhập vào giới tính:(true/false)");

        String grade = UtilInput.getString("Nhập vào lớp:");

        double score = UtilInput.getDouble("Nhập vào điểm số:");

        return new Student(id, name, day, sex, grade, score);
    }

    @Override
    public void add() {
        try {
            DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);

            Student student;
            while (true) {
                student = createStudent();
                for (Student item : DataService.studentList) {
                    if (item.getID().equals(student.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.studentList.add(student);
                UtilFile.writeStudentFile(UtilFile.PATH_STUDENT,DataService.studentList);
                break;
            }
        } catch (DuplicateIDException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void display() {
        for (Student student : DataService.studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void delete(String id) {
        Student student=find(id);
        if(student!=null){
            DataService.studentList.remove(student);
            UtilFile.writeStudentFile(UtilFile.PATH_STUDENT,DataService.studentList);
        }

    }

    public Student find(String id) {
        DataService.studentList=UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (Student student : DataService.studentList) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> search(String name) {
        DataService.studentList=UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : DataService.studentList) {
            if (UtilCompare.approximateComparison(student.getName(), name)) {
                students.add(student);
            }
        }

        return students;
    }

    @Override
    public void insertionSort() {
        DataService.studentList=UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (int i = 1; i < DataService.studentList.size(); i++) {
            Student key =  DataService.studentList.get(i);
            int j = i;
            for (; j > 0; j--) {

                if (UtilCompare.compareString(key.getName(), ( DataService.studentList.get(j - 1)).getName()) == -1) {
                    DataService.studentList.set(j, DataService.studentList.get(j - 1));
                } else {
                    break;
                }
            }
            DataService.studentList.set(j, key);
        }
        UtilFile.writeStudentFile(UtilFile.PATH_STUDENT,DataService.studentList);
    }

    @Override
    public void update(String string) {

    }


}

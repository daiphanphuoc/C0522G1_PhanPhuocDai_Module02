package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Student;
import exercise.student_management_file.service.IStudentService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {


    public Student createStudent(String id) {

        String name = UtilInput.getString("Nhập vào tên:");

        String day = UtilInput.getString("Nhập vào ngày sinh:");

        boolean sex = UtilInput.getBoolean("Nhập vào giới tính:(true/false)");

        String grade = UtilInput.getString("Nhập vào lớp:");

        double score = UtilInput.getDouble("Nhập vào điểm số:");

        return new Student(id, name, day, sex, grade, score);
    }

    @Override
    public void add() {
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        Student student;
        while (true) {
            try {

                String id = UtilInput.getString("Nhập vào mã:");
                for (Student item : studentList) {
                    if (item.getID().equals(id)) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }
                student = createStudent(id);
                studentList.add(student);
                UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, studentList);
                break;
            } catch (DuplicateIDException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void display() {
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void delete(String id) {
        Student student = find(id);
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        if (student != null) {
            if (UtilInput.getBoolean("Bạn chắc chắn muốn xóa.true/false")) {
                studentList.remove(student);
                UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, studentList);
                System.out.println("Xóa thành công.");
            }
        } else {
            System.out.println("Không tìm thấy.");
        }
    }

    public Student find(String id) {
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (Student student : studentList) {
            if (student.getID().equals(id)) {
                return student;
            }
        }

        return null;
    }

    public ArrayList<Student> search(String name) {
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (UtilCompare.approximateComparison(student.getName(), name)) {
                students.add(student);
            }
        }

        return students;
    }

    @Override
    public void insertionSort() {
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (int i = 1; i < studentList.size(); i++) {
            Student key = studentList.get(i);
            int j = i;

            for (; j > 0; j--) {
                int lessName = UtilCompare.compareString(key.getName(), (studentList.get(j - 1)).getName());
                if (lessName == -1) {
                    studentList.set(j, studentList.get(j - 1));
                } else if (lessName == 0) {
                    int lessId = UtilCompare.compareString(key.getID(), (studentList.get(j - 1)).getID());
                    if (lessId == -1) {
                        studentList.set(j, studentList.get(j - 1));
                    }
                } else {
                    break;
                }
            }

            studentList.set(j, key);
        }
        UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, studentList);
    }

    @Override
    public void update(String id) {
        Student student = find(id);
        List<Student> studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        if (student != null) {
            Student temp = createStudent(id);
            int i = studentList.indexOf(student);
            studentList.set(i, temp);
            UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, studentList);
        } else {
            System.err.println("Không có sinh viên này");
        }
    }
}

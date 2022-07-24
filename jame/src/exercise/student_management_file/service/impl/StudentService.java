package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Student;
import exercise.student_management_file.service.IStudentService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;

public class StudentService implements IStudentService<Student> {


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

        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        Student student;
        while (true) {
            try {
                student = createStudent();
                for (Student item : DataService.studentList) {
                    if (item.getID().equals(student.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.studentList.add(student);
                UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, DataService.studentList);
                DataService.studentList.clear();
                break;
            } catch (DuplicateIDException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void display() {
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (Student student : DataService.studentList) {
            System.out.println(student);
        }
        DataService.studentList.clear();
    }

    @Override
    public void delete(String id) {
        Student student = find(id);
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        if (student != null) {
            if (UtilInput.getBoolean("Bạn chắc chắn muốn xóa.true/false")) {
                DataService.studentList.remove(student);
                UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, DataService.studentList);
                System.out.println("Xóa thành công.");
                DataService.studentList.clear();
            }
        } else {
            System.out.println("Không tìm thấy.");
        }

    }

    public Student find(String id) {
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (Student student : DataService.studentList) {
            if (student.getID().equals(id)) {
                DataService.studentList.clear();
                return student;
            }
        }
        DataService.studentList.clear();
        return null;
    }

    public ArrayList<Student> search(String name) {
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : DataService.studentList) {
            if (UtilCompare.approximateComparison(student.getName(), name)) {
                students.add(student);
            }
        }
        DataService.studentList.clear();
        return students;
    }

    @Override
    public void insertionSort() {
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        for (int i = 1; i < DataService.studentList.size(); i++) {
            Student key = DataService.studentList.get(i);
            int j = i;
            for (; j > 0; j--) {
                int lessName = UtilCompare.compareString(key.getName(), (DataService.studentList.get(j - 1)).getName());
                if (lessName == -1) {
                    DataService.studentList.set(j, DataService.studentList.get(j - 1));
                } else if (lessName == 0) {
                    int lessId = UtilCompare.compareString(key.getID(), (DataService.studentList.get(j - 1)).getID());
                    if (lessId == -1) {
                        DataService.studentList.set(j, DataService.studentList.get(j - 1));
                    }
                } else {
                    break;
                }
            }
            DataService.studentList.set(j, key);
        }
        UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, DataService.studentList);

        DataService.studentList.clear();
    }

    @Override
    public void update(String id) {
        Student student = find(id);
        System.out.println(student);
        DataService.studentList = UtilFile.readStudentFile(UtilFile.PATH_STUDENT);
        System.out.println("2");
        if (student != null) {
            Student temp = createStudent();
            while (true) {
                if (id.equals(temp.getID())) {
                    int i = DataService.studentList.indexOf(student);
                    System.out.println(i);
                    DataService.studentList.set(i, temp);
                    UtilFile.writeStudentFile(UtilFile.PATH_STUDENT, DataService.studentList);
                    DataService.studentList.clear();
                    break;
                } else {
                    System.err.println("Bạn không được thay đổi id của sinh viên");
                }
            }
        } else {
            System.out.println("Không có sinh viên này");
        }

    }
}

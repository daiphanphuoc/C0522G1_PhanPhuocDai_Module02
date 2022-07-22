package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Person;
import exercise.student_management_file.model.Teacher;
import exercise.student_management_file.service.ITeacherService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private Scanner sc = new Scanner(System.in);

    public Teacher createTeacher() {
        String id = UtilInput.getString("Nhập vào mã:");

        String name = UtilInput.getString("Nhập vào tên:");

        String day = UtilInput.getString("Nhập vào ngày sinh:");

        boolean sex = UtilInput.getBoolean("Nhập vào giới tính:(true/false)");

        String specialize = UtilInput.getString("Nhập vào chuyên môn:");

        return new Teacher(id, name, day, sex, specialize);
    }


    @Override
    public void add() {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);

        Teacher teacher;
        while (true) {

            try {
                teacher = createTeacher();

                for (Teacher item : DataService.teacherList) {
                    if (item.getID().equals(teacher.getID())) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                DataService.teacherList.add(teacher);
                UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, DataService.teacherList);
                break;

            } catch (DuplicateIDException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

    }


    @Override
    public void display() {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (Teacher teacher : DataService.teacherList) {
            if (teacher instanceof Teacher) {
                System.out.println(teacher);
            }
        }

    }

    @Override
    public void delete(String id) {
        Teacher teacher = find(id);
        if (teacher != null) {
            DataService.teacherList.remove(teacher);
            UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, DataService.teacherList);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public Teacher find(String id) {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);

        for (Teacher teacher : DataService.teacherList) {
            if (teacher.getID().equals(id)) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Teacher> search(String name) {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Teacher item : DataService.teacherList) {
            if (UtilCompare.approximateComparison(item.getName(), name)) {
                teachers.add(item);
            }
        }

        // System.out.println(students.size());
        return teachers;
    }

    @Override
    public void insertionSort() {
        DataService.teacherList=UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (int i = 1; i < DataService.teacherList.size(); i++) {
            Teacher key =  DataService.teacherList.get(i);
            int j = i;
            for (; j > 0; j--) {

                if (UtilCompare.compareString(key.getName(), ( DataService.teacherList.get(j - 1)).getName()) == -1) {
                    DataService.teacherList.set(j, DataService.teacherList.get(j - 1));
                } else {
                    break;
                }
            }
            DataService.teacherList.set(j, key);
        }
        UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER,DataService.teacherList);
    }

    @Override
    public void update(String string) {

    }

}

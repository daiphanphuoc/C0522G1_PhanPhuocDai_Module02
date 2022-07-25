package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Teacher;
import exercise.student_management_file.service.ITeacherService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService<Teacher> {

    public Teacher createTeacher(String id) {

        String name = UtilInput.getString("Nhập vào tên:");

        String day = UtilInput.getString("Nhập vào ngày sinh:");

        boolean sex = UtilInput.getBoolean("Nhập vào giới tính:(true/false)");

        String specialize = UtilInput.getString("Nhập vào chuyên môn:");

        return new Teacher(id, name, day, sex, specialize);
    }

    @Override
    public void add() {
        List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);

        while (true) {

            try {
                String id = UtilInput.getString("Nhập vào mã:");
                for (Teacher item : teacherList) {
                    if (item.getID().equals(id)) {
                        throw new DuplicateIDException("Trùng mã");
                    }
                }

                teacherList.add(createTeacher(id));
                UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, teacherList);
                break;

            } catch (DuplicateIDException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }


    @Override
    public void display() {
        List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void delete(String id) {
        Teacher teacher = find(id);
        if (teacher != null) {
            if (UtilInput.getBoolean("Bạn chắc chắn muốn xóa.true/false")) {
                List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
                teacherList.remove(teacher);
                UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, teacherList);
                System.out.println("Xóa thành công!");
            }
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public Teacher find(String id) {
        List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (Teacher teacher : teacherList) {
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

        return teachers;
    }

    @Override
    public void insertionSort() {
        List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (int i = 1; i < teacherList.size(); i++) {
            Teacher key = teacherList.get(i);
            int j = i;
            for (; j > 0; j--) {
                int lessName = UtilCompare.compareString(key.getName(), (teacherList.get(j - 1)).getName());
                if (lessName == -1) {
                    teacherList.set(j, teacherList.get(j - 1));
                } else if (lessName == 0) {
                    int lessId = UtilCompare.compareString(key.getID(), (teacherList.get(j - 1)).getID());
                    if (lessId == -1) {
                        teacherList.set(j, teacherList.get(j - 1));
                    }
                } else {
                    break;
                }
            }
            teacherList.set(j, key);
        }
        UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, teacherList);
    }

    @Override
    public void update(String id) {
        Teacher teacher = find(id);
        List<Teacher> teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        if (teacher != null) {
            Teacher temp = createTeacher(id);
            int index = teacherList.indexOf(teacher);
            teacherList.set(index, temp);
            UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, teacherList);
        } else {
            System.err.println("Không có giảng viên này");
        }
    }

}

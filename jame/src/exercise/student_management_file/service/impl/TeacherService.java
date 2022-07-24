package exercise.student_management_file.service.impl;

import exercise.student_management_file._exception.DuplicateIDException;
import exercise.student_management_file.model.Teacher;
import exercise.student_management_file.service.ITeacherService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import exercise.student_management_file.until.UtilInput;

import java.util.ArrayList;

public class TeacherService implements ITeacherService<Teacher> {

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
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }


    @Override
    public void display() {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (Teacher teacher : DataService.teacherList) {

            System.out.println(teacher);

        }

    }

    @Override
    public void delete(String id) {
        Teacher teacher = find(id);
        if (teacher != null) {
            if (UtilInput.getBoolean("Bạn chắc chắn muốn xóa.true/false")) {
                DataService.teacherList.remove(teacher);
                UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, DataService.teacherList);
                System.out.println("Xóa thành công!");
            }
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

        return teachers;
    }

    @Override
    public void insertionSort() {
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        for (int i = 1; i < DataService.teacherList.size(); i++) {
            Teacher key = DataService.teacherList.get(i);
            int j = i;
            for (; j > 0; j--) {
                int lessName = UtilCompare.compareString(key.getName(), (DataService.teacherList.get(j - 1)).getName());
                if (lessName == -1) {
                    DataService.teacherList.set(j, DataService.teacherList.get(j - 1));
                } else if (lessName == 0) {
                    int lessId = UtilCompare.compareString(key.getID(), (DataService.teacherList.get(j - 1)).getID());
                    if (lessId == -1) {
                        DataService.teacherList.set(j, DataService.teacherList.get(j - 1));
                    }
                } else {
                    break;
                }
            }
            DataService.teacherList.set(j, key);
        }
        UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, DataService.teacherList);
    }

    @Override
    public void update(String id) {
        Teacher teacher = find(id);
        DataService.teacherList = UtilFile.readTeacherFile(UtilFile.PATH_TEACHER);
        if (teacher != null) {
            while (true) {
                Teacher temp = createTeacher();
                if (temp.getID().equals(id)) {
                    int index = DataService.teacherList.indexOf(teacher);
                    DataService.teacherList.set(index, temp);
                    UtilFile.writeTeacherFile(UtilFile.PATH_TEACHER, DataService.teacherList);
                    DataService.teacherList.clear();
                    break;
                } else {
                    System.out.println("Không thể thay đổi id của giảng viên," +
                            " nhập lại thông tin cần thay đổi");
                }
            }

        } else {
            System.err.println("Không có giảng viên này");
        }

    }

}

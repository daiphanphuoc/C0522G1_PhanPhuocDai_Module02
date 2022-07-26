package ss19_regex.exercise.study_class;

import exercise.student_management_file.until.UtilInput;

public class Main {
    public static void main(String[] args) {
        StudyClass studyClass=new StudyClass();
        System.out.println(studyClass.validate(UtilInput.getString("Nhập vào mã lớp học")));
        System.out.println(studyClass.validate(UtilInput.getString("Nhập vào mã lớp học")));
        System.out.println(studyClass.validate(UtilInput.getString("Nhập vào mã lớp học")));
        System.out.println(studyClass.validate(UtilInput.getString("Nhập vào mã lớp học")));
        System.out.println(studyClass.validate(UtilInput.getString("Nhập vào mã lớp học")));
    }
}

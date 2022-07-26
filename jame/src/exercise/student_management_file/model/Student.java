package exercise.student_management_file.model;

import exercise.student_management_file._exception.DuplicateIDException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Student extends Person {
    private String grade;
    private double score;

    public Student() {
    }

    public Student(String iD, String name, Date dateOfBirth,
                   boolean sex, String grade, double score) {
        super(iD, name, dateOfBirth, sex);
        this.grade = grade;
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) throws DuplicateIDException {
        if (score < 0) {
            throw new DuplicateIDException("Không có điểm âm!!!");
        }
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }

    public String getInfo() {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        String birth=df.format(getDateOfBirth());
        return String.format("%s,%s,%s,%s,%s,%s", getID(), getName(),
                birth, isSex(), getGrade(), getScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getID().equals(student.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }
}

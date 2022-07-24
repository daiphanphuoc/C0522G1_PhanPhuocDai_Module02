package exercise.student_management_file.model;

import exercise.student_management_file._exception.DuplicateIDException;

import java.util.Objects;

public class Student extends Person {
    private String grade;
    private double score;

    public Student() {
    }

    public Student(String iD, String name, String dateOfBirth,
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
        return String.format("%s,%s,%s,%s,%s,%s", getID(), getName(),
                getDateOfBirth(), isSex(), getGrade(), getScore());
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

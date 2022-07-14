package exercise.student_management.model;

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

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}

package exercise.student_management_file.model;

import java.util.Objects;

public class Teacher extends Person {
    private String specialize;

    public Teacher() {
    }

    public Teacher(String iD, String name, String dateOfBirth, boolean sex, String specialize) {
        super(iD, name, dateOfBirth, sex);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +super.toString()+
                ", specialize='" + specialize + '\'' +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s", getID(), getName(),
                getDateOfBirth(), isSex(), getSpecialize());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getID(),teacher.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }
}

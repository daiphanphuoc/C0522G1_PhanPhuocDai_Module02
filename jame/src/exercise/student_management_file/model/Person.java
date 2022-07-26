package exercise.student_management_file.model;

import java.util.Date;

public abstract class Person {
    private String iD;
    private String name;
    private Date dateOfBirth;
    private boolean sex;

    public Person() {
    }

    public Person(String iD, String name, Date dateOfBirth, boolean sex) {
        this.iD = iD;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public abstract String getInfo();

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "iD='" + iD + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex=" + (sex ? "Nam" : "Nữ");
    }
}

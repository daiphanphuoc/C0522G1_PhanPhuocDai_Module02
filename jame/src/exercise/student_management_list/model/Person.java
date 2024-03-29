package exercise.student_management_list.model;

public abstract class Person {
    private String iD;
    private String name;
    private String dateOfBirth;
    private boolean sex;

    public Person() {
    }

    public Person(String iD, String name, String dateOfBirth, boolean sex) {
        this.iD = iD;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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
        return "Person{" +
                "iD='" + iD + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex=" + (sex?"Nam":"Nữ") +
                '}';
    }
}

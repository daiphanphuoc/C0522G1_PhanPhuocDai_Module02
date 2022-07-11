package ss05_access_modifier_static.exercise.class_only_write;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name="John";
        this.classes="C02";
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}

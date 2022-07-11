package models;

import java.util.Date;

public class Employee extends Person{
    final String DEGREE="";
    final String POSITION="";
    private String iDStaff;
    private String degree;
    private String position;
    private double  salary;

    public Employee() {
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone, String email, String iDStaff, String degree, String position, double salary) {
        super(name, iDCitizen, birthday, sex, phone, email);
        this.iDStaff = iDStaff;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getIDStaff() {
        return iDStaff;
    }

    public void setIDStaff(String iDStaff) {
        this.iDStaff = iDStaff;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

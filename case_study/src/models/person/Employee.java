package models.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person {
    private String iDStaff;
    private String degree;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String iDStaff, String degree, String position, double salary) {
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

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", iDStaff='" + iDStaff + '\'' +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} ";
    }

    public String getInfo() {
        Date date = getBirthday();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateString  = df.format(date);

        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", getName(), getIDCitizen(), dateString,
                isSex(), getPhone(), getEmail(), getIDStaff(), getDegree(), getPosition(), getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return iDStaff.equals(employee.iDStaff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDStaff);
    }
}

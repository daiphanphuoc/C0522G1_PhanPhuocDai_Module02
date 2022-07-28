package services.impl;

import _exception.DegreeException;
import _exception.IDCitizenException;
import _exception.IDStaffException;

import static libs.InputUtil.*;

import _exception.PositionException;
import models.Employee;
import org.jetbrains.annotations.NotNull;
import services.EmployeeService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static libs.IOPersonUtil.readEmployeeFile;
import static libs.IOPersonUtil.writeEmployeeFile;
import static libs.InputPersonUtil.*;
import static libs.InputUtil.getBoolean;
import static libs.InputUtil.getDouble;

public class EmployeeServiceImpl implements EmployeeService<Employee> {

    public static final String PATH_EMPLOYEE = "case_study/src/data/employee.csv";
    private static EmployeeServiceImpl employeeService;

    private EmployeeServiceImpl() {
    }

    public static synchronized EmployeeServiceImpl getInstance(){
        if(employeeService==null){
            employeeService=new EmployeeServiceImpl();
        }
        return employeeService;
    }

    @Override
    public void add() {
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        String iDStaff;
        String iDCitizen;

        try {
            employees = readEmployeeFile(PATH_EMPLOYEE);
        } catch (ParseException | NumberFormatException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                iDStaff = inputIDEmployee("Nhập vào mã số nhân viên của nhân viên:");
                for (Employee e : employees) {
                    if (e.getIDStaff().equals(iDStaff)) {
                        throw new IDStaffException("Trùng mã nhân viên");
                    }
                }
                break;
            } catch (IDStaffException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        while (true) {
            try {
                iDCitizen = inputIDCitizen("Nhập vào mã số công dân của nhân viên:");
                for (Employee e : employees) {
                    if (e.getIDCitizen().equals(iDCitizen)) {
                        throw new IDCitizenException("Trùng mã công dân");
                    }
                }
                break;
            } catch (IDCitizenException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        employee = createEmployee(iDCitizen, iDStaff);
        employees.add(employee);
        writeEmployeeFile(PATH_EMPLOYEE, employees);
        System.out.println("Thêm mới thành công");
    }


    private @NotNull Employee createEmployee(String iDCitizen, String iDStaff) {
        String name = inputNameStandard("Nhập vào tên nhân viên:");

        Date birthday = inputDateOfEmployee("Nhập vào ngày sinh của nhân viên:");

        boolean sex = getBoolean("Nhập vào giới tính của nhân viên:Nam-true/Nữ-false");

        String phone = inputPhone("Nhập vào số điện thoại của nhân viên:");

        String email = inputEmail("Nhập vào email của nhân viên:");

        String degree;
        while (true) {
            try {
                System.out.println(" choose :\n INTERMEDIATE   -->  Trung cấp\n" +
                        "COLLEGE -->Cao đẳng\n" +
                        "UNDERGRADUATE -->Đại học\n" +
                        "GRADUATE  -->  sau đại học");
                degree = inputDegree(getString("Nhập vào chuyên môn của nhân viên:"));
                break;
            } catch (DegreeException | IllegalArgumentException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        String position;
        while (true) {
            try {
                System.out.println("RECEPTIONIST -->Lễ tân\n" +
                        "WAITER --> Phục vụ\n" +
                        "SPECIALIST -->  Chuyên viên\n" +
                        "SUPERVISOR -->Giám sát\n" +
                        "MANAGER --> Quản lý\n" +
                        "DIRECTOR --> Giám đốc");
                position = inputPosition(getString("Nhập vào chức vụ/ vị trí của nhân viên:"));
                break;
            } catch (PositionException | IllegalArgumentException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        double salary = getDouble("Nhập vào lương nhân viên của nhân viên:");

        return new Employee(name, iDCitizen, birthday, sex, phone, email, iDStaff, degree, position, salary);
    }

    @Override
    public void display() {
        List<Employee> employees;
        try {
            employees = readEmployeeFile(PATH_EMPLOYEE);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            employees.clear();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id) {
        List<Employee> employees;
        Employee employee = find(id);
        if (employee != null) {
            try {
                employees = readEmployeeFile(PATH_EMPLOYEE);
                int index = employees.indexOf(employee);
                String iDCitizen;
                do {
                    iDCitizen = inputIDCitizen("Nhập vào mã số công dân của nhân viên:");
                    try {
                        for (Employee temp : employees) {
                            if (temp.getIDCitizen().equals(iDCitizen) &&
                                    !temp.getIDStaff().equals(employee.getIDStaff())) {
                                throw new IDCitizenException("Đã có mã số công dân này, nhập lại");
                            }
                        }
                        break;
                    } catch (IDCitizenException e) {
                        e.printStackTrace();
                    }
                } while (true);

                employees.set(index, createEmployee(iDCitizen, id));
                writeEmployeeFile(PATH_EMPLOYEE, employees);
                employees.clear();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void remove(String id) {
        List<Employee> employees;
        try {
            Employee employee = find(id);
            if (employee != null) {
                employees = readEmployeeFile(PATH_EMPLOYEE);
                if (getBoolean("Bạn chắc chắn muốn xóa: true-->xóa")) {
                    employees.remove(employee);
                    writeEmployeeFile(PATH_EMPLOYEE, employees);
                }
            } else {
                System.out.println("Không có nhân viên có id=" + id);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee find(@NotNull String id) {
        List<Employee> employees;
        try {
            employees = readEmployeeFile(PATH_EMPLOYEE);
            for (Employee employee : employees) {
                if (id.equals(employee.getIDStaff())) {
                    return employee;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Employee> search(@NotNull String name) {
        List<Employee> employees;
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        String[] arrName = name.toLowerCase().split(" ");
        try {
            employees = readEmployeeFile(PATH_EMPLOYEE);
            for (Employee employee : employees) {
                String nameItem = employee.getName().toLowerCase();
                for (String str : arrName) {
                    if (nameItem.contains(str) && str.length() > 1) {
                        employeeArrayList.add(employee);
                        break;
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return employeeArrayList;
    }
}

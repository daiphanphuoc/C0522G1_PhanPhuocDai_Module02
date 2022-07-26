package services.impl;

import _exception.IDCitizenException;
import _exception.IDStaffException;
import libs.IOFileUtil;
import libs.InputUtil;
import models.Employee;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import services.EmployeeService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService<Employee> {
    public static List<Employee> employees;
    public static final String PATH_EMPLOYEE = "case_study/src/data/employee.csv";


    @Override
    public void add() {
        while (true) {
            try {
                employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
                Employee employee = createEmployee();
                for (Employee e : employees) {
                    if (e.getIDStaff().equals(employee.getIDStaff())) {
                        throw new IDStaffException("Trùng mã nhân viên");
                    }
                    if (e.getIDCitizen().equals(employee.getIDCitizen())) {
                        throw new IDCitizenException("Trùng mã công dân");
                    }
                }

                employees.add(employee);
                IOFileUtil.writeEmployeeFile(PATH_EMPLOYEE, employees);
                System.out.println("Thêm mới thành công");
                employees.clear();
                break;
            } catch (ParseException | NumberFormatException | IDStaffException | IDCitizenException e) {
                e.printStackTrace();
            }
        }
    }

    @Contract(" -> new")
    private @NotNull Employee createEmployee() {
        String name = InputUtil.getString("Nhập vào tên nhân viên:");
        String iDCitizen = InputUtil.getString("Nhập vào mã số công dân của nhân viên:");
        Date birthday = InputUtil.getDate("Nhập vào ngày sinh của nhân viên:");
        boolean sex = InputUtil.getBoolean("Nhập vào giới tính của nhân viên:Nam-true/Nữ-false");
        String phone = InputUtil.getString("Nhập vào mã số điện thoại của nhân viên:");
        String email = InputUtil.getString("Nhập vào mã email của nhân viên:");
        String iDStaff = InputUtil.getString("Nhập vào mã số nhân viên của nhân viên:");
        String degree = InputUtil.getString("Nhập vào chuyên môn của nhân viên:");
        String position = InputUtil.getString("Nhập vào chức vụ/ vị trí của nhân viên:");
        double salary = InputUtil.getDouble("Nhập vào lương nhân viên của nhân viên:");
        return new Employee(name, iDCitizen, birthday, sex, phone, email, iDStaff, degree, position, salary);
    }

    @Override
    public void display() {
        try {
            employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
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
        Employee employee = find(id);
        if (employee != null) {
            try {
                employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
                int index = employees.indexOf(employee);
                employee.setName(InputUtil.getString("Nhập vào tên nhân viên:"));
                do {
                    employee.setIDCitizen(InputUtil.getString("Nhập vào mã số công dân của nhân viên:"));
                    try {
                        for (Employee temp : employees) {
                            if (temp.getIDCitizen().equals(employee.getIDCitizen()) && !temp.getIDStaff().equals(employee.getIDStaff())) {
                                throw new IDCitizenException("Đã có mã số công dân này");
                            }
                        }
                        break;
                    } catch (IDCitizenException e) {
                        e.printStackTrace();
                    }
                } while (true);
                employee.setBirthday(InputUtil.getDate("Nhập vào ngày sinh của nhân viên(dd/mm/yyyy):"));
                employee.setSex(InputUtil.getBoolean("Nhập vào giới tính của nhân viên:Nam-true/Nữ-false"));
                employee.setPhone(InputUtil.getString("Nhập vào mã số điện thoại của nhân viên:"));
                employee.setEmail(InputUtil.getString("Nhập vào mã email của nhân viên:"));
                employee.setDegree(InputUtil.getString("Nhập vào chuyên môn của nhân viên:"));
                employee.setPosition(InputUtil.getString("Nhập vào chức vụ/ vị trí của nhân viên:"));
                employee.setSalary(InputUtil.getDouble("Nhập vào lương nhân viên của nhân viên:"));
                employees.set(index, employee);
                IOFileUtil.writeEmployeeFile(PATH_EMPLOYEE, employees);
                employees.clear();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void remove(String id) {
        try {
            Employee employee = find(id);
            if (employee != null) {
                employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
                if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa: true-->xóa")) {
                    employees.remove(employee);
                    IOFileUtil.writeEmployeeFile(PATH_EMPLOYEE, employees);
                }
            } else {
                System.out.println("Không có nhân viên có id=" + id);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            employees.clear();
        }

    }

    @Override
    public Employee find(@NotNull String id) {
        try {
            employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
            for (Employee employee : employees) {
                if (id.equals(employee.getIDStaff())) {
                    return employee;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            employees.clear();
        }

        return null;
    }

    @Override
    public ArrayList<Employee> search(@NotNull String name) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        String[] arrName = name.toLowerCase().split(" ");
        try {
            employees = IOFileUtil.readEmployeeFile(PATH_EMPLOYEE);
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
        } finally {
            employees.clear();
        }
        return employeeArrayList;
    }
}

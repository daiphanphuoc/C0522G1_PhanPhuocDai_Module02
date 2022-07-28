package libs;

import models.Customer;
import models.Employee;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IOPersonUtil extends IOFileUtil {
    public static @NotNull List<Employee> readEmployeeFile(String path) throws ParseException, NumberFormatException {
        List<Employee> employees = new ArrayList<>();
        List<String> strings = null;
        try {
            strings = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr;
        assert strings != null;
        for (String s : strings) {
            arr = s.split(",");
            if (arr.length == 10) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = df.parse(arr[2]);
                Employee employee = new Employee(arr[0], arr[1], date, Boolean.parseBoolean(arr[3]),
                        arr[4], arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9]));
                employees.add(employee);
            }
        }
        return employees;
    }

    public static void writeEmployeeFile(String path, @NotNull List<Employee> employees) {
        StringBuilder data = new StringBuilder();
        for (Employee employee : employees) {
            data.append(employee.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length() - 1);
        try {
            writeFile(path, data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static @NotNull List<Customer> readCustomerFile(String path) throws ParseException {
        List<Customer> customers = new ArrayList<>();
        List<String> strings = null;
        try {
            strings = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr;
        assert strings != null;
        for (String s : strings) {
            arr = s.split(",");
            if (arr.length == 9) {
                DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = simpleDateFormat.parse(arr[2]);
                Customer customer = new Customer(arr[0], arr[1], date, Boolean.parseBoolean(arr[3]),
                        arr[4], arr[5], arr[6], arr[7], arr[8]);
                customers.add(customer);
            }
        }
        return customers;
    }

    public static void writeCustomerFile(String path, @NotNull List<Customer> customers) {
        StringBuilder data = new StringBuilder();
        for (Customer customer : customers) {
            data.append(customer.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length() - 1);
        try {
            writeFile(path, data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

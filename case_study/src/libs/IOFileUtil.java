package libs;

import models.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class IOFileUtil {

    private static @NotNull
    List<String> readFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        return strings;
    }

    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static @NotNull List<Employee> readEmployeeFile(String path) throws ParseException,NumberFormatException {
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

    public static void writeEmployeeFile(String path, @NotNull List<Employee> employees)  {
        StringBuilder data =new StringBuilder();
        for (Employee employee:employees){
            data.append(employee.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length()-1);
        try {
            writeFile(path,data.toString());
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

    public static void writeCustomerFile(String path, @NotNull List<Customer> customers)  {
        StringBuilder data =new StringBuilder();
        for (Customer customer:customers){
            data.append(customer.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length()-1);
        try {
            writeFile(path,data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static @NotNull LinkedHashMap<Facility,Integer> readFacilityFile(String path) throws NumberFormatException {
        LinkedHashMap<Facility,Integer> facilities = new LinkedHashMap<>();
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
                Facility facility = new Villa(arr[0], arr[1], Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]), Double.parseDouble(arr[8]));

                facilities.put(facility,Integer.parseInt(arr[9]));
            }else if(arr.length == 8){
                Facility facility = new House(arr[0], arr[1], Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]));

                facilities.put(facility,Integer.parseInt(arr[8]));
            }else if(arr.length == 7){
                Facility facility = new Room(arr[0], arr[1], Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),
                        Integer.parseInt(arr[4]), arr[5], arr[6]);

                facilities.put(facility,Integer.parseInt(arr[7]));
            }
        }
        return facilities;
    }

    public static void writeFacilityFile(String path, @NotNull LinkedHashMap<Facility,Integer> facilities)  {
        StringBuilder data =new StringBuilder();
        for (Facility facility:facilities.keySet()){
            data.append(facility.getInfo()).append(facilities.get(facility)).append("\n");
        }
        data.deleteCharAt(data.length()-1);
        try {
            writeFile(path,data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

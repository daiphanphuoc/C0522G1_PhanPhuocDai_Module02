package services.impl;

import _exception.IDCitizenException;
import _exception.IDCustomerException;
import libs.IOFileUtil;
import libs.InputUtil;
import models.Customer;
import org.jetbrains.annotations.NotNull;
import services.CustomerService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService<Customer> {
    public static List<Customer> customers;
    public static final String PATH_CUSTOMER = "case_study/src/data/customer.csv";

    @Override
    public void add() {
        while (true) {
            try {
                customers = IOFileUtil.readCustomerFile(PATH_CUSTOMER);
                Customer customer = createCustomer();
                for (Customer e : customers) {
                    if (e.getIDCustomer().equals(customer.getIDCustomer())) {
                        throw new IDCustomerException("Trùng mã khách hàng");
                    }
                    if (e.getIDCitizen().equals(customer.getIDCitizen())) {
                        throw new IDCitizenException("Trùng mã công dân");
                    }
                }
                customers.add(customer);
                IOFileUtil.writeCustomerFile(PATH_CUSTOMER, customers);
                System.out.println("Thêm mới thành công");
                customers.clear();
                break;
            } catch (ParseException | NumberFormatException | IDCitizenException | IDCustomerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void display() {
        try {
            customers = IOFileUtil.readCustomerFile(PATH_CUSTOMER);
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            customers.clear();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(String id) {
        Customer customer = find(id);
        if (customer != null) {
            try {
                customers = IOFileUtil.readCustomerFile(PATH_CUSTOMER);
                int index = customers.indexOf(customer);

                customer.setName(InputUtil.getString("Nhập vào tên khách hàng:"));
                do {
                    customer.setIDCitizen(InputUtil.getString("Nhập vào mã số công dân của khách hàng:"));
                    try {
                        for (Customer temp : customers) {
                            if (temp.getIDCitizen().equals(customer.getIDCitizen())) {
                                throw new IDCitizenException("Đã có mã số công dân này");
                            }
                        }
                        break;
                    } catch (IDCitizenException e) {
                        e.printStackTrace();
                    }
                } while (true);
                customer.setBirthday(InputUtil.getDate("Nhập vào ngày sinh của khách hàng(dd/mm/yyyy):"));
                customer.setSex(InputUtil.getBoolean("Nhập vào giới tính của khách hàng:Nam-true/Nữ-false"));
                customer.setPhone(InputUtil.getString("Nhập vào mã số điện thoại của khách hàng:"));
                customer.setEmail(InputUtil.getString("Nhập vào mã email của khách hàng:"));
                customer.setCustomerType(InputUtil.getString("Nhập vào loại khách hàng:"));
                customer.setAddress(InputUtil.getString("Nhập vào địa chỉ khách hàng:"));

                customers.set(index, customer);
                IOFileUtil.writeCustomerFile(PATH_CUSTOMER, customers);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                customers.clear();
            }
        } else {
            System.out.println("không có khách hàng có id=" + id);
        }
    }

    @Override
    public void remove(String id) {
        Customer customer = find(id);
        if (customer != null) {
            try {
                customers = IOFileUtil.readCustomerFile(PATH_CUSTOMER);
                if (InputUtil.getBoolean("Bạn chắc chắn muốn xóa, nhập true-->xóa")) {
                    customers.remove(customer);
                    IOFileUtil.writeCustomerFile(PATH_CUSTOMER, customers);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                customers.clear();
            }
        } else {
            System.out.println("không có khách hàng có id=" + id);
        }
    }

    @Override
    public Customer find(@NotNull String id) {
        try {
            customers = IOFileUtil.readCustomerFile(PATH_CUSTOMER);
            for (Customer customer : customers) {
                if (id.equals(customer.getIDCustomer())) {
                    return customer;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            customers.clear();
        }
        return null;
    }

    @Override
    public ArrayList<Customer> search(String name) {
        return null;
    }


    private @NotNull Customer createCustomer() {
        String name = InputUtil.getString("Nhập vào tên khách hàng:");
        String iDCitizen = InputUtil.getString("Nhập vào mã số công dân của khách hàng:");
        Date birthday = InputUtil.getDate("Nhập vào ngày sinh của khách hàng:");
        boolean sex = InputUtil.getBoolean("Nhập vào giới tính của khách hàng:Nam-true/Nữ-false");
        String phone = InputUtil.getString("Nhập vào mã số điện thoại của khách hàng:");
        String email = InputUtil.getString("Nhập vào mã email của khách hàng:");
        String iDStaff = InputUtil.getString("Nhập vào mã số nhân viên của khách hàng:");
        String customerType = InputUtil.getString("Nhập vào loại khách hàng:");
        String address = InputUtil.getString("Nhập vào địa chỉ của khách hàng:");
        return new Customer(name, iDCitizen, birthday, sex, phone, email, iDStaff, customerType, address);
    }
}
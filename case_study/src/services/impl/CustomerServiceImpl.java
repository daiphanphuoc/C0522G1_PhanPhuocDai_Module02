package services.impl;

import _exception.person.IDCitizenException;
import _exception.person.IDCustomerException;
import models.Path;
import models.person.Customer;
import models.person.Employee;
import org.jetbrains.annotations.NotNull;
import services.CustomerService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static libs.InputPersonUtil.*;
import static libs.InputUtil.getBoolean;
import static libs.InputUtil.getString;
import static libs.io_file.IOPersonUtil.*;

public class CustomerServiceImpl implements CustomerService<Customer> {
    private static CustomerServiceImpl customerService;

    private CustomerServiceImpl() {
    }

    public static synchronized CustomerServiceImpl getInstance() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl();
        }
        return customerService;
    }

    @Override
    public void add() {
        List<Customer> customers = new ArrayList<>();

        String idCustomer;
        String iDCitizen;
        try {
            customers = readCustomerFile(Path.CUSTOMER.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                iDCitizen = inputIDCitizen("Nhập vào mã số công dân của khách hàng:");
                for (Customer e : customers) {
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

        while (true) {
            try {
                idCustomer = inputIDCustomer("Nhập vào mã số khách hàng:");
                for (Customer e : customers) {
                    if (e.getIDCustomer().equals(idCustomer)) {
                        throw new IDCustomerException("Trùng mã khách hàng");
                    }
                }

                break;
            } catch (IDCustomerException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }

        Customer customer = createCustomer(iDCitizen, idCustomer);
        customers.add(customer);
        writeCustomerFile(Path.CUSTOMER.getPath(), customers);
        System.out.println("Thêm mới thành công");

    }

    public void add(String idCustomer) {
        List<Customer> customers = new ArrayList<>();
        String iDCitizen;
        try {
            customers = readCustomerFile(Path.CUSTOMER.getPath());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                iDCitizen = inputIDCitizen("Nhập vào mã số công dân của khách hàng:");
                for (Customer e : customers) {
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

        Customer customer = createCustomer(iDCitizen, idCustomer);
        customers.add(customer);
        writeCustomerFile(Path.CUSTOMER.getPath(), customers);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void display() {
        List<Customer> customers;
        try {
            customers = readCustomerFile(Path.CUSTOMER.getPath());
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(String iDCustomer) {
        List<Customer> customers;
        Customer customer = find(iDCustomer);
        if (customer != null) {
            try {
                customers = readCustomerFile(Path.CUSTOMER.getPath());
                int index = customers.indexOf(customer);
                String iDCitizen;
                while (true) {
                    iDCitizen = getString("Nhập vào mã số công dân của khách hàng:");
                    try {
                        for (Customer temp : customers) {
                            if (temp.getIDCitizen().equals(iDCitizen)) {
                                throw new IDCitizenException("Đã có mã số công dân này");
                            }
                        }
                        break;
                    } catch (IDCitizenException e) {
                        e.printStackTrace();
                        System.out.print("");
                    }
                }

                customer = createCustomer(iDCitizen, iDCustomer);
                customers.set(index, customer);
                writeCustomerFile(Path.CUSTOMER.getPath(), customers);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.print("");
            }
        } else {
            System.out.println("không có khách hàng có id=" + iDCustomer);
        }
    }

    @Override
    public void remove(String idCustomer) {
        List<Customer> customers;
        Customer customer = find(idCustomer);
        if (customer != null) {
            try {
                customers = readCustomerFile(Path.CUSTOMER.getPath());
                if (getBoolean("Bạn chắc chắn muốn xóa, nhập true-->xóa")) {
                    customers.remove(customer);
                    writeCustomerFile(Path.CUSTOMER.getPath(), customers);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("không có khách hàng có id=" + idCustomer);
        }
    }

    @Override
    public Customer find(@NotNull String idCustomer) {
        List<Customer> customers;
        try {
            customers = readCustomerFile(Path.CUSTOMER.getPath());
            for (Customer customer : customers) {
                if (idCustomer.equals(customer.getIDCustomer())) {
                    return customer;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Customer> search(String name) {
        List<Customer> employees;
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        String[] arrName = name.toLowerCase().split(" ");
        try {
            employees = readCustomerFile(Path.CUSTOMER.getPath());
            for (Customer customer : employees) {
                String nameItem = customer.getName().toLowerCase();
                for (String str : arrName) {
                    if (nameItem.contains(str) && str.length() > 1) {
                        customerArrayList.add(customer);
                        break;
                    }
                }
            }
        } catch (ParseException | NumberFormatException e) {
            e.printStackTrace();
        }

        return customerArrayList;
    }


    private @NotNull Customer createCustomer(String iDCitizen, String iDCustomer) {
        String name = inputNameStandard("Nhập vào tên khách hàng:");

        Date birthday = inputDateOfCustomer("Nhập vào ngày sinh của khách hàng:");

        boolean sex = getBoolean("Nhập vào giới tính của khách hàng:Nam-true/Nữ-false");

        String phone = inputPhone("Nhập vào số điện thoại của khách hàng:");

        String email = inputEmail("Nhập vào email của khách hàng:");

        String customerType;
        while (true) {
            try {
                System.out.println("Chọn loại khách hàng:\nDiamond: Kim cương\n" +
                        "Platinium: Bạch kim\n" +
                        "Gold: Vàng\n" +
                        "Silver: Bạc\n" +
                        "Member: Thành viên");
                customerType = inputCustomerType(getString("Nhập vào loại khách hàng:"));
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }


        String address = getString("Nhập vào địa chỉ của khách hàng:");

        return new Customer(name, iDCitizen, birthday, sex, phone, email, iDCustomer, customerType, address);
    }


}
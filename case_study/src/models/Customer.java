package models;

import java.util.Date;

public class Customer extends Person{

    private String iDCustomer;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String iDCitizen, Date birthday, boolean sex, String phone, String email, String iDCustomer, String customerType, String address) {
        super(name, iDCitizen, birthday, sex, phone, email);
        this.iDCustomer = iDCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public String getIDCustomer() {
        return iDCustomer;
    }

    public void setIDCustomer(String iDCustomer) {
        this.iDCustomer = iDCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

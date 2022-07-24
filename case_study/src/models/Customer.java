package models;

import java.util.Date;
import java.util.Objects;

public class Customer extends Person {

    private String iDCustomer;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String iDCustomer, String customerType, String address) {
        super(name, iDCitizen, birthday, sex, phone, email);
        this.iDCustomer = iDCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", getName(), getIDCitizen(), getBirthday(), isSex(),
                getPhone(), getEmail(), getIDCustomer(), getCustomerType(), getAddress());
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

    @Override
    public String toString() {
        return "Customer{" +  super.toString()+
                ", iDCustomer='" + iDCustomer + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return iDCustomer.equals(customer.iDCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDCustomer);
    }
}

package models;

public class Contract {

    String contractNumber;
    private String bookingID;
    private double firstMoney;
    private double totalMoney;
    private String iDCustomer;

    public Contract() {
    }

    public Contract(String contractNumber, String bookingID, double money, double totalMoney, String iDCustomer) {
        this.contractNumber = contractNumber;
        this.bookingID = bookingID;
        this.firstMoney = money;
        this.totalMoney = totalMoney;
        this.iDCustomer = iDCustomer;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public double getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(double firstMoney) {
        this.firstMoney = firstMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getiDCustomer() {
        return iDCustomer;
    }

    public void setiDCustomer(String iDCustomer) {
        this.iDCustomer = iDCustomer;
    }
}

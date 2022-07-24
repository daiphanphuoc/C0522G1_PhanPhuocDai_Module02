package models;

public class Contract {

    private String contractNumber;
    private String bookingID;
    private double firstMoney;
    private double totalMoney;
    private String iDCustomer;

    public Contract() {
    }

    public Contract(String contractNumber, String bookingID, double money,
                    double totalMoney, String iDCustomer) {
        this.contractNumber = contractNumber;
        this.bookingID = bookingID;
        this.firstMoney = money;
        this.totalMoney = totalMoney;
        this.iDCustomer = iDCustomer;
    }
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s",getContractNumber(),getBookingID(),
                getFirstMoney(),getTotalMoney(),getIDCustomer());
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

    public String getIDCustomer() {
        return iDCustomer;
    }

    public void setIDCustomer(String iDCustomer) {
        this.iDCustomer = iDCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", firstMoney=" + firstMoney +
                ", totalMoney=" + totalMoney +
                ", iDCustomer='" + iDCustomer + '\'' +
                '}';
    }
}

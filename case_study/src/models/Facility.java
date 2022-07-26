package models;

public abstract class Facility {
    private String iDFacility;
    private String nameFacility;
    private double leasedArea;
    private double rentalCosts;
    private int maxPerson;
    private String rentalType;

    public Facility() {
    }

    public Facility(String iDFacility, String nameFacility, double leasedArea, double rentalCosts, int maxPerson, String rentalType) {
        this.iDFacility = iDFacility;
        this.nameFacility = nameFacility;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public abstract String getInfo();

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public double getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(double leasedArea) {
        this.leasedArea = leasedArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getIDFacility() {
        return iDFacility;
    }

    public void setIDFacility(String iDFacility) {
        this.iDFacility = iDFacility;
    }

    @Override
    public String toString() {
        return "iDFacility='" + iDFacility + '\'' +
                ", nameFacility='" + nameFacility + '\'' +
                ", leasedArea='" + leasedArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentalType + '\'';
    }
}

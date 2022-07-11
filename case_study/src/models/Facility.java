package models;

public abstract class Facility {

    private String nameFacility;
    private String leasedArea;
    private double rentalCosts;
    private int maxPerson;
    private String  rentalType;

    public Facility() {
    }

    public Facility(String nameFacility, String leasedArea, double rentalCosts, int maxPerson, String rentalType) {
        this.nameFacility = nameFacility;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(String leasedArea) {
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
}

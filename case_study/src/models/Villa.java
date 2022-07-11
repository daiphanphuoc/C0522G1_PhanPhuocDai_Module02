package models;

public class Villa extends House{

    private double areaPool;


    public Villa() {
    }

    public Villa(String nameFacility, String leasedArea, double rentalCosts, int maxPerson, String rentalType, String room, int floor, double areaPool) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, room, floor);
        this.areaPool = areaPool;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }


}

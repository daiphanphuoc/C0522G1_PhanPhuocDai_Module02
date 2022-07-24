package models;

import java.util.Objects;

public class Villa extends Facility {
    private String room;
    private int floor;
    private double areaPool;


    public Villa() {
    }

    public Villa(String iDFacility, String nameFacility, String leasedArea, double rentalCosts,
                 int maxPerson, String rentalType, String room, int floor, double areaPool) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType);
        this.room = room;
        this.floor = floor;
        this.areaPool = areaPool;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getIDFacility(), getNameFacility(), getLeasedArea(),
                getRentalCosts(), getMaxPerson(), getRentalType(), getRoom(), getFloor(), areaPool);
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{ " + super.toString() +
                "room='" + room + '\'' +
                ", floor=" + floor +
                ", areaPool=" + areaPool +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Villa villa = (Villa) o;
        return getIDFacility().equals(villa.getIDFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}

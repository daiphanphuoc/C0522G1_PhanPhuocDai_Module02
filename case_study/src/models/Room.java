package models;

public class Room extends Facility{
    String free;

    public Room() {
    }

    public Room(String nameFacility, String leasedArea, double rentalCosts, int maxPerson, String rentalType, String free) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType);
        this.free = free;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}

package models;

public class House extends Facility{
    private String room;
    private int floor;

    public House() {
    }

    public House(String nameFacility, String leasedArea, double rentalCosts, int maxPerson, String rentalType, String room, int floor) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType);
        this.room = room;
        this.floor = floor;
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
}
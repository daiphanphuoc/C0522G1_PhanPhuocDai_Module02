package models;

import java.util.Objects;

public class House extends Facility {
    private String room;
    private int floor;

    public House() {
    }

    public House(String iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                 int maxPerson, String rentalType, String room, int floor) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType);
        this.room = room;
        this.floor = floor;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getIDFacility(), getNameFacility(), getLeasedArea(),
                getRentalCosts(), getMaxPerson(), getRentalType(), room, floor);
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
        return "House{ " + super.toString() +
                ", room='" + room + '\'' +
                ", floor=" + floor +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return getIDFacility().equals(house.getIDFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}

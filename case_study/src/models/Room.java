package models;

import java.util.Objects;

public class Room extends Facility{
    String free;

    public Room() {
    }

    public Room(String iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                int maxPerson, String rentalType, String free) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType);
        this.free = free;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",getIDFacility(), getNameFacility(), getLeasedArea(),
                getRentalCosts(), getMaxPerson(), getRentalType(), free);
    }
    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Room{ " + super.toString() +
                "free='" + free + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(getIDFacility(), room.getIDFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}

package exercise.transportation_management.model;

public class Truck extends Transport{
    private double tonnage;

    public Truck() {
    }

    public Truck(String seaOfControl, String manufacturerName,
                 String yearOfManufacture, String owner, double tonnage) {
        super(seaOfControl, manufacturerName, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{"+ super.toString()+
                "tonnage=" + tonnage +
                "} " ;
    }
}

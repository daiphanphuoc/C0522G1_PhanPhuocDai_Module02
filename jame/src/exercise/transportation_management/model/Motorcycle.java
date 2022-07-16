package exercise.transportation_management.model;

public class Motorcycle extends Transport{
    private String wattage;

    public Motorcycle() {
    }

    public Motorcycle(String seaOfControl, String manufacturerName,
                      String yearOfManufacture, String owner, String wattage) {
        super(seaOfControl, manufacturerName, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                super.toString()+
                "wattage=" + wattage +
                "} " ;
    }
}

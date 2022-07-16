package exercise.transportation_management.model;

public abstract class Transport {
    private String seaOfControl;
    private String manufacturerName;
    private String yearOfManufacture;
    private String owner;

    public Transport() {
    }

    public Transport(String seaOfControl, String manufacturerName,
                     String yearOfManufacture, String owner) {
        this.seaOfControl = seaOfControl;
        this.manufacturerName = manufacturerName;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getSeaOfControl() {
        return seaOfControl;
    }

    public void setSeaOfControl(String seaOfControl) {
        this.seaOfControl = seaOfControl;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "seaOfControl='" + seaOfControl + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

package exercise.transportation_management.model;

public class Car extends Transport{
    private int seats;
    private String typeCar;

    public Car() {
    }

    public Car(String seaOfControl, String manufacturerName,
               String yearOfManufacture, String owner,
               int seats, String typeCar) {
        super(seaOfControl, manufacturerName, yearOfManufacture, owner);
        this.seats = seats;
        this.typeCar = typeCar;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car{" +super.toString()+
                "seats=" + seats +
                ", typeCar='" + typeCar + '\'' +
                "} " ;
    }
}

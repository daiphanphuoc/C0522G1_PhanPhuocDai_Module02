package ss04_oop_class.exercise.flan;

public class Flan {
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Flan() {
        this.speed = LOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Flan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Flan{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    ", 'fan is on'}";
        }
        return "Flan{" +
                " radius=" + radius +
                ", color='" + color + '\'' +
                ", 'fan is off'}";
    }
}

package ss06_inheritance_polymorphirm.practice.model;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
        this.length=1;
        this.width=1;
    }

    public Rectangle(String color, boolean filled, double length, double width) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea(){
        return getLength()*getWidth();
    }

    public double getPerimeter(){
        return 2*(getWidth()+getLength());
    }

    @Override
    public String toString() {
        return "A Rectangle with " +
                "length=" + length +
                " and width=" + width +
                ", which is a subclass of "+super.toString();
    }
}

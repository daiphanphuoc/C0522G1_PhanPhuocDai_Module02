package ss07_abstract_class_and_interface.exercise.resizeable.model;

import ss07_abstract_class_and_interface.exercise.resizeable.services.Resizeable;

public class Square extends Shape implements Resizeable {
    private double size = 1;

    public Square() {
    }

    public Square(double size) {
        this.size = size;
    }

    public Square(double size, String color, boolean filled) {
        super(color, filled);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPerimeter() {
        return this.getSize() * 4;
    }

    public double getArea() {
        return Math.pow(this.getSize(), 2);
    }

    @Override
    public String toString() {
        return String.format("A Square with size= %.2f which is a subclass of %s"
               ,getSize() ,super.toString());
    }

    @Override
    public void resize(double percent) {
        this.size += this.size * percent / 100;
    }
}

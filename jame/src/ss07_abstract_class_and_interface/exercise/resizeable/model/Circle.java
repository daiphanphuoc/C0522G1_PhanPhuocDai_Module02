package ss07_abstract_class_and_interface.exercise.resizeable.model;

import ss07_abstract_class_and_interface.exercise.resizeable.services.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("A Circle with radius=%.2f , which is a subclass of ",getRadius() , super.toString());
    }

    @Override
    public void resize(double percent) {
        this.radius+=this.radius*percent/100;
    }
}

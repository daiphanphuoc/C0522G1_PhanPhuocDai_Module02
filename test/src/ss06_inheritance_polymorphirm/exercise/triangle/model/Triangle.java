package ss06_inheritance_polymorphirm.exercise.triangle.model;

import ss06_inheritance_polymorphirm.practice.model.Shape;

public class Triangle extends Shape {
    double side1 = 1;
    double side2 = 1;
    double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
public Triangle(double side1, double side2, double side3,String color,boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setSide(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        double s = p * (p - getSide1()) * (p - getSide2()) * (p - getSide3());
        return Math.pow(s, 0.5);
    }

    public double getPerimeter() {
        return side1 + side3 + side2;
    }



    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                "color="+ super.getColor()+'}';
    }
}

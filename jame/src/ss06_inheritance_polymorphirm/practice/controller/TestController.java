package ss06_inheritance_polymorphirm.practice.controller;

import ss06_inheritance_polymorphirm.practice.model.Circle;
import ss06_inheritance_polymorphirm.practice.model.Rectangle;
import ss06_inheritance_polymorphirm.practice.model.Square;

public class TestController {
    public static void circleTest(){
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", false,3.5);
        System.out.println(circle);
    }

    public static void rectangleTest(){
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle( "orange", true,2.5, 3.8);
        System.out.println(rectangle);
    }

    public static void squareTest(){
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square( "yellow", true,5.8);
        System.out.println(square);
    }
    public static void main(String[] args) {

        circleTest();
        rectangleTest();
        squareTest();
    }
}

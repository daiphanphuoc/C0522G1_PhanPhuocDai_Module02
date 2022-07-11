package ss07_abstract_class_and_interface.exercise.resizeable.controller;

import ss07_abstract_class_and_interface.exercise.resizeable.model.Rectangle;

public class RectangleController {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}

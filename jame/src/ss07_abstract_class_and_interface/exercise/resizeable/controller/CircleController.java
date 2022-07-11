package ss07_abstract_class_and_interface.exercise.resizeable.controller;

import ss07_abstract_class_and_interface.exercise.resizeable.model.Circle;

public class CircleController {

        public static void main(String[] args) {
            Circle circle = new Circle();
            System.out.println(circle);

            circle = new Circle(3.5);
            System.out.println(circle);

            circle = new Circle(3.5, "indigo", false);
            System.out.println(circle);
        }
    }


package ss07_abstract_class_and_interface.practice.comparator.controller;

import ss06_inheritance_polymorphirm.exercise.circle_cylinder.model.Circle;
import ss07_abstract_class_and_interface.practice.comparator.model.CircleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorController {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6,"red");
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo");

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }

}

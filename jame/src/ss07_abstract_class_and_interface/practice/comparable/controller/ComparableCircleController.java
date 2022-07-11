package ss07_abstract_class_and_interface.practice.comparable.controller;

import ss07_abstract_class_and_interface.practice.comparable.model.ComparableCircle;

import java.util.Arrays;

public class ComparableCircleController {
    public static void main(String[] args) {

        ComparableCircle[] circles = new ComparableCircle[4];
        circles[0] = new ComparableCircle(3.6,"red");
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo");
        circles[3] = new ComparableCircle(3.5, "indigo");

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

    }
}

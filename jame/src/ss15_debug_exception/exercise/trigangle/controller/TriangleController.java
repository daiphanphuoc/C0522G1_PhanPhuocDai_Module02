package ss15_debug_exception.exercise.trigangle.controller;

import ss15_debug_exception.exercise.trigangle.model.Triangle;
import ss15_debug_exception.exercise.trigangle._exception.IllegalTriangleException;
import ss15_debug_exception.exercise.trigangle.service.impl.TriangleService;

public class TriangleController {
    public void menu() {
        Triangle triangle = new Triangle();
        while (true) {
            try {
                triangle = (new TriangleService()).create();
                break;
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
            }
        }

        System.out.println(triangle);
    }
}

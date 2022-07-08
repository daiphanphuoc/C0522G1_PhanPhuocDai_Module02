package ss06_inheritance_polymorphirm.exercise.point.controller;

import ss06_inheritance_polymorphirm.exercise.point.model.Point3D;
import ss06_inheritance_polymorphirm.exercise.point.model.Point2D;

public class TestController {
    public static void testPoint2D() {

        Point2D point2D = new Point2D(3, 2);
        System.out.println(point2D);
    }

    public static void testPoint3D() {

        Point3D point3D = new Point3D(3, 2,9);
        System.out.println(point3D);
    }

    public static void main(String[] args) {
        testPoint2D();
        testPoint3D();
    }
}

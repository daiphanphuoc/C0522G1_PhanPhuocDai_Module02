package ss06_inheritance_polymorphirm.exercise.moveable.controller;

import ss06_inheritance_polymorphirm.exercise.moveable.model.MovablePoint;
import ss06_inheritance_polymorphirm.exercise.point.model.Point2D;

public class MainController {
    public static void main(String[] args) {
        Point2D point2D=new Point2D(2,3);
        System.out.println(point2D);
        Point2D movablePoint = new MovablePoint(2,3,5,5);
        System.out.println(movablePoint);
        for (int i=0;i<3;i++){
            System.out.println(((MovablePoint) movablePoint).move());
        }
    }
}

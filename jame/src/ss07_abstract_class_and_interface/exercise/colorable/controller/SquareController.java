package ss07_abstract_class_and_interface.exercise.colorable.controller;

import ss07_abstract_class_and_interface.exercise.colorable.model.Square;
import ss07_abstract_class_and_interface.exercise.colorable.services.Colorable;
import ss07_abstract_class_and_interface.exercise.resizeable.model.Circle;
import ss07_abstract_class_and_interface.exercise.resizeable.model.Shape;


public class SquareController {
    public static void main(String[] args) {
        Shape[] shape = new Shape[10];
        shape[0]=new Square(3);
        shape[1]=new Square(3.2);
        shape[2]=new Square(2.3);
        shape[3]=new Square(3.3);
        shape[4]=new Square(3.9);
        shape[5]=new Circle(5);
        shape[6]=new Circle(6.5);
        shape[7]=new Circle(5.2);
        shape[8]=new Circle(5.6);
        shape[9]=new Circle(2.5);

        for (Shape s: shape){
            if(s instanceof Circle){
                System.out.println(((Circle) s).getArea());
            }else{
                System.out.println(((Square) s).getArea());
            }

            if(s instanceof Colorable){
                ((Colorable) s).howToColor();
            }
        }


    }
}

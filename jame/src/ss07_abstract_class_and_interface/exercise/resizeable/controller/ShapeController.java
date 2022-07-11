package ss07_abstract_class_and_interface.exercise.resizeable.controller;

import ss07_abstract_class_and_interface.exercise.resizeable.model.Circle;
import ss07_abstract_class_and_interface.exercise.resizeable.model.Rectangle;
import ss07_abstract_class_and_interface.exercise.resizeable.model.Shape;
import ss07_abstract_class_and_interface.exercise.resizeable.model.Square;

public class ShapeController {
    public static void main(String[] args) {
        Shape[] shape = new Shape[100];

        for (int i = 0; i < 33; i = i + 1) {
            shape[i] = new Circle(Math.random() * 20);
        }

        for (int i = 33; i < 66; i++) {
            shape[i] = new Square(Math.random() * 30);
        }

        for (int i = 66; i < 100; i++) {
            shape[i] = new Rectangle(Math.random() * 10, Math.random() * 30);
        }
        System.out.println("trước khi tăng:");
        for (int i = 0; i < shape.length; i++) {
            System.out.printf("diện tích hình  %d: %.2f\n",i+1,shape[i].getArea());

            if (shape[i] instanceof Circle) {
                ((Circle) shape[i]).resize(Math.random() * 100);
            } else if (shape[i] instanceof Square) {
                ((Square) shape[i]).resize(Math.random() * 100);
            } else {
                ((Rectangle) shape[i]).resize(Math.random() * 100);
            }
        }

        System.out.println("Sau khi tăng:");
        int i=0;
        for (Shape s:shape){
            System.out.printf("diện tích hình  %d: %.2f\n",(i+1),s.getArea());
            i++;
        }

    }

}

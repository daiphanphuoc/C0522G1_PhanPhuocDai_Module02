package ss06_inheritance_polymorphirm.exercise.triangle.controller;

import ss06_inheritance_polymorphirm.exercise.triangle.model.Triangle;

import java.util.Scanner;

public class TriangleController {
    public static Scanner sc = new Scanner(System.in);

    public static float inputPositive(String target) {
        float f;
        do {
            f=sc.nextFloat();
            if(f<=0){
                System.out.println(target);
            }
        }while (f<=0);
        return f;
    }

    public static void main(String[] args) {
        double size1;
        double size2;
        double size3;
        String color;

        System.out.println("Nhập vào màu sắc của tam giác:");
        color = sc.nextLine();
        
        boolean isTriangle;
        do {
            System.out.println("Nhập vào size cạnh 1 của tam giác:");
            size1 = inputPositive("cạnh của 1 tam giác phải là 1 số  dương:");

            System.out.println("Nhập vào size cạnh 2 của tam giác:");
            size2 = inputPositive("cạnh của 1 tam giác phải là 1 số  dương:");


            System.out.println("Nhập vào size cạnh 3 của tam giác:");
            size3 = inputPositive("cạnh của 1 tam giác phải là 1 số  dương:");

            isTriangle = size1 + size2 > size3 && size1 + size3 > size2 && size2 + size3 > size1;
            if (!isTriangle) {
                System.out.println("Nhập sai, kiểm tra lại:");
            }
        } while (!isTriangle);

        Triangle triangle=new Triangle(size1,size2,size3,color,true);

        System.out.println(triangle);
        System.out.println("Chu vi tam giác: " + triangle.getPerimeter());
        System.out.println("Diện tích tam giác: " +triangle.getArea());


    }
}

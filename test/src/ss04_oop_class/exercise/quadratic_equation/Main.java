package ss04_oop_class.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào hằng số a: ");
        double a=sc.nextDouble();

        System.out.println("Nhập vào hằng số b: ");
        double b=sc.nextDouble();

        System.out.println("Nhập vào hằng số c: ");
        double c=sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);

        double delta = quadraticEquation.getDiscriminant();

        System.out.println(quadraticEquation);

        if (delta < 0) {
            System.out.println("The equation has no roots");
        } else if (delta == 0) {
            System.out.println("The equation has one roots :" + quadraticEquation.getRoot2());
        } else {
            System.out.println("The equation has two roots :" + quadraticEquation.getRoot2() + " and " + quadraticEquation.getRoot1());
        }

    }
}

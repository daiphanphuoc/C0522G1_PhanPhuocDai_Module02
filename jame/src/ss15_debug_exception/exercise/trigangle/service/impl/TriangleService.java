package ss15_debug_exception.exercise.trigangle.service.impl;

import ss15_debug_exception.exercise.trigangle._exception.IllegalTriangleException;
import ss15_debug_exception.exercise.trigangle.model.Triangle;
import ss15_debug_exception.exercise.trigangle.service.IService;

import java.util.Scanner;

public class TriangleService implements IService<Triangle> {
    Scanner sc = new Scanner(System.in);

    @Override
    public Triangle create() throws IllegalTriangleException {

        double a;
        double b;
        double c;

        while (true) {
            try {
                System.out.println("Nhập vào cạnh a: ");
                a = Double.parseDouble(sc.nextLine());

                System.out.println("Nhập vào cạnh b: ");
                b = Double.parseDouble(sc.nextLine());

                System.out.println("Nhập vào cạnh c: ");
                c = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Nhập lại 3 cạnh của tam giác:");
            }
        }

        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Không phải 3 cạnh của tam giác, nhập lại.");
        }

        return new Triangle(a, b, c);

    }

}


package ss15_debug_exception.exercise.trigangle.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static double getDouble(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.println(target);
        double d;
        while (true) {
            try {
                d = sc.nextDouble();
                return d;
            } catch (InputMismatchException e) {
                e.getMessage();
            }
        }
    }
}

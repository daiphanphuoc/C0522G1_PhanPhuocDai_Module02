package ss01_introduction.practice;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {

        System.out.println("Giải phương trình bâc nhất;");
        System.out.println("Cho phương trình dạng 'a * x + b = c', vui lòng nhập hằng số:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("phương trình có nghiệm x = %.2f!\n", answer);
        } else {
            if (b == c) {
                System.out.print("phương trình có vô số x!");
            } else {
                System.out.print("Vô nghiệm!");
            }
        }
    }
}


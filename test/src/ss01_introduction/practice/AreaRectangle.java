package ss01_introduction.practice;



import java.util.Scanner;

public class AreaRectangle {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;

        //System.out.println("Area is: " + area);
        System.out.printf("Area is : %.1f",area);
    }
}


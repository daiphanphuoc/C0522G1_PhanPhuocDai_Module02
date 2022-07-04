package ss02_Loop.exercise;

import java.util.Scanner;

public class FigureDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice=-1;
        while (choice!=0){

            System.out.println("Menu: ");
            System.out.println("1. Draw Retangle:");
            System.out.println("2. Draw square triangle top left:");
            System.out.println("3. Draw square triangle top right:");
            System.out.println("4. Draw square triangle bottom right:");
            System.out.println("5. Draw square triangle bottom left:");
            System.out.println("6. Draw  triangle display:");
            System.out.println("7. Draw  triangle empty display:");

            choice= sc.nextInt();

            switch (choice){
                case 1:
                    rectangle(8,5);
                    break;
                case 2:
                    squareTriangleTopLeft(6);
                    break;
                case 3:
                    squareTriangleTopRight(6);
                    break;
                case 4:
                    squareTriangleBottomRight(6);
                    break;
                case 5:
                    squareTriangleBottomLeft(6);
                    break;
                case 6:
                    triangleDisplay(7);
                    break;
                    case 7:
                        triangleEmptyDisplay(7);
                    break;
                default:
                    System.out.println();
            }
        }






    }

    public static void triangleDisplay(int hight) {
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < 2 * hight - 1; j++) {
                if (i + j < hight - 1 || j - i > hight - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void triangleEmptyDisplay(int hight) {
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < 2 * hight - 1; j++) {
                if (i + j == hight - 1 || j - i == hight - 1 || i == hight - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void rectangle(int longs, int wide) {
        for (int i = 0; i < longs; i++) {
            for (int j = 0; j < wide; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

    }

    public static void squareTriangleTopLeft(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = height; j > i; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void squareTriangleTopRight(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (j - i >= 0) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void squareTriangleBottomLeft(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void squareTriangleBottomRight(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if(i+j<height-1){
                    System.out.print("   ");
                }else{
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }
}

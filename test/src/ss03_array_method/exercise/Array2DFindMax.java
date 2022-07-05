package ss03_array_method.exercise;

import java.util.Scanner;

public class Array2DFindMax {
    public static void main(String[] args) {
        int row = inputPositive("Nhập vào chiều dài của ma trận: ");

        int col = inputPositive("Nhập vào cột của ma trận: ");

        double[][] arr2D = new double[row][col];

        createArray2D(arr2D);

        maxOfArray2D(arr2D);
    }


    private static void maxOfArray2D(double[][] arr2D) {
        double max = arr2D[0][0];
        int rowMax = 0;
        int colMax = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (max < arr2D[i][j]) {
                    max = arr2D[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }

        System.out.println("Phần tử lớn nhất của ma trận:" + max + " tại dòng: " + rowMax + " và cột :" + colMax);
    }

    private static void createArray2D( double[][] arr2D) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                arr2D[i][j] = sc.nextDouble();
            }
        }
    }

    private static int inputPositive(String target) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.println(target);
            n = sc.nextInt();
            if (n < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (n < 1);
        return n;
    }


}

package ss03_array_method.exercise;

import java.util.Scanner;

public class ArraySumCollum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row;
        row = inputPositive(sc, "Nhập vào chiều dài của ma trận: ");

        int col;
        col = inputPositive(sc, "Nhập vào cột của ma trận: ");

        double[][] arr2D = new double[row][col];

        createArray2D(sc, arr2D);

        int indexCol;
        boolean isNotIndexCol;
        do {
            System.out.println("nhập vào cột cần tính tổng: ");
            indexCol = sc.nextInt();
            isNotIndexCol = indexCol < 0 || indexCol > col - 1;
            if (isNotIndexCol) {
                System.out.println("không có cột, nhập lại:");
            }
        } while (isNotIndexCol);

        double sum = 0d;
        for (int i = 0; i < arr2D.length; i++) {
            sum = sum + arr2D[i][indexCol];
        }

        System.out.printf("%.2f là tổng các phần tử trên cột %d của mảng", sum, indexCol);
    }

    private static void createArray2D(Scanner sc, double[][] arr2D) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                arr2D[i][j] = sc.nextDouble();
            }
        }
    }

    private static int inputPositive(Scanner sc, String s) {
        int n;
        do {
            System.out.println(s);
            n = sc.nextInt();
            if (n < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (n < 1);
        return n;
    }
}

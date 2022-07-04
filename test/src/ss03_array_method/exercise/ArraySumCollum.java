package ss03_array_method.exercise;

import java.util.Scanner;

public class ArraySumCollum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row;
        do {
            System.out.println("Nhập vào chiều dài của ma trận: ");
            row = sc.nextInt();
            if (row < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (row < 1);

        int col;
        do {
            System.out.println("Nhập vào cột của ma trận: ");
            col = sc.nextInt();
            if (col < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (col < 1);

        double[][] arr2D = new double[row][col];

        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                arr2D[i][j] = sc.nextDouble();
            }
        }

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
}

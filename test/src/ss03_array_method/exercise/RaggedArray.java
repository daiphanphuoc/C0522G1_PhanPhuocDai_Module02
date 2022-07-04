package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class RaggedArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row;
        do {
            System.out.println("Nhập vào chiều dài của mảng: ");
            row = sc.nextInt();
            if (row < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (row < 1);

        int[][] arr2D = new int[row][];

        for (int i = 0; i < arr2D.length; i++) {
            int col;
            do {
                System.out.println("Nhập vào cột của dòng: " + i);
                col = sc.nextInt();
                if (col < 1) {
                    System.out.println("nhập sai, nhập lại: ");
                }
            } while (col < 1);

            arr2D[i] = new int[col];

            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                arr2D[i][j] = sc.nextInt();
            }

        }

        System.out.println("Mảng vừa nhập: ");
        for (int i=0;i<arr2D.length;i++){
            System.out.print(Arrays.toString(arr2D[i]));
            System.out.println();
        }

    }
}

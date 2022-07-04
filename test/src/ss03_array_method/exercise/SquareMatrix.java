package ss03_array_method.exercise;

import java.util.Scanner;

public class SquareMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row;
        do {
            System.out.println("Nhập vào chiều dài của ma trận vuông: ");
            row = sc.nextInt();
            if (row < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (row < 1);

        int [][] matrix = new int[row][row];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum=0;
        for (int i=0;i<matrix.length;i++){
            sum+=matrix[i][i];
        }

        System.out.printf("%d là tổng đường chéo chính của ma trận",sum);
    }
}

package ss03_array_method.exercise;

import java.util.Scanner;

public class SquareMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size= inputPostive(sc,"Nhập vào kích thước của ma trận vuông: ");

        int [][] matrix = new int[size][size];
        createMatrix(sc, matrix);

        int sum;
        sum = sumMainCross(matrix);

        RaggedArray.displayArray2D(matrix);

        System.out.printf("%d là tổng đường chéo chính của ma trận",sum);
    }

    private static int inputPostive(Scanner sc, String str) {
        int size;
        do {
            System.out.println(str);
            size = sc.nextInt();
            if (size < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (size < 1);
        return size;
    }

    private static void createMatrix(Scanner sc, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static int sumMainCross(int[][] matrix) {
        int sum=0;
        for (int i = 0; i< matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
}

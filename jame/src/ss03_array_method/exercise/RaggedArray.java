package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class RaggedArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row;
        row = inputPositive(sc, "Nhập vào chiều dài của mảng: ");

        int[][] arr2D = new int[row][];

        createArrayRagged(sc, arr2D);

        displayArray2D(arr2D);

    }

    private static void createArrayRagged(Scanner sc, int[][] arr2D) {
        for (int i = 0; i < arr2D.length; i++) {
            int col = inputPositive(sc, "Nhập vào cột của dòng: " + i);
            arr2D[i] = new int[col];

            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử thứ [%d][%d]:", i, j);
                arr2D[i][j] = sc.nextInt();
            }

        }
    }

    public static void displayArray2D(int[][] arr2D) {
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i< arr2D.length; i++){
            System.out.print(Arrays.toString(arr2D[i]));
            System.out.println();
        }
    }

    private static int inputPositive(Scanner sc, String s) {
        int row;
        do {
            System.out.println(s);
            row = sc.nextInt();
            if (row < 1) {
                System.out.println("nhập sai, nhập lại: ");
            }
        } while (row < 1);
        return row;
    }
}

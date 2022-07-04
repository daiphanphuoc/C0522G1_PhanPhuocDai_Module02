package ss03_array_method.exercise;

import java.util.Scanner;

public class Array2DFindMax {
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

        double max=arr2D[0][0];
        int rowMax=0;
        int colMax=0;
        for (int i=0; i<arr2D.length;i++){
            for (int j=0; j<arr2D[i].length;j++){
                if(max<arr2D[i][j]){
                    max=arr2D[i][j];
                    rowMax=i;
                    colMax=j;
                }
            }
        }

        System.out.println("Phần tử lớn nhất của ma trận:"+ max+ " tại dòng: "+rowMax+" và cột :"+ colMax);
    }
}

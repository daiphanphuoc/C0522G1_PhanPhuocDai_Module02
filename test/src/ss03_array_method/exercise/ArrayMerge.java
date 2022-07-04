package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        do {
            System.out.println("nhập vào chiều dài của mảng: ");
            size = sc.nextInt();
            if (size < 1) {
                System.out.println("nhập sai, kiểm tra lại: ");
            }
        } while (size < 1);

        int[] arrOne = new int[size];
        for (int i = 0; i < arrOne.length; i++) {
            System.out.print("\nNhập vào phần tử thứ " + i + " : ");
            arrOne[i] = sc.nextInt();
        }

        int[] arrTwo = new int[size];
        for (int i = 0; i < arrTwo.length; i++) {
            System.out.print("\nNhập vào phần tử thứ " + i + " : ");
            arrTwo[i] = sc.nextInt();
        }

        System.out.print("\nmảng thứ nhất vừa nhập: ");
        System.out.print(Arrays.toString(arrOne));
        System.out.print("\nmảng thứ hai vừa nhập: ");
        System.out.print(Arrays.toString(arrTwo));

        int[] arrMerge = mergeArray(arrOne, arrTwo);
        System.out.print("\nmảng sau khi gộp: ");
        System.out.print(Arrays.toString(arrMerge));

    }


    public static int[] mergeArray(int[] arrOne, int[] arrTwo) {
        int[] arr = new int[arrOne.length + arrTwo.length];
        for (int i = 0; i < arrOne.length; i++) {
            arr[i] = arrOne[i];
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arr[i + arrOne.length] = arrTwo[i];
        }
        return arr;
    }

}

package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        size = inputPositive(sc, "nhập vào chiều dài của mảng thứ nhất: ");
        int[] arrOne = new int[size];
        createArray(sc, arrOne);

        size = inputPositive(sc, "nhập vào chiều dài của mảng thứ hai: ");
        int[] arrTwo = new int[size];
        createArray(sc, arrTwo);

        displayArray(arrOne, "\nmảng thứ nhất vừa nhập: ");
        displayArray(arrTwo, "\nmảng thứ hai vừa nhập: ");

        int[] arrMerge = mergeArray(arrOne, arrTwo);
        displayArray(arrMerge, "\nMảng sau khi gộp: ");

    }

    private static void createArray(Scanner sc, int[] arrOne) {
        for (int i = 0; i < arrOne.length; i++) {
            System.out.print("\nNhập vào phần tử thứ " + i + " : ");
            arrOne[i] = sc.nextInt();
        }
    }

    private static int inputPositive(Scanner sc, String target) {
        int size;
        do {
            System.out.println(target);
            size = sc.nextInt();
            if (size < 1) {
                System.out.println("nhập sai, kiểm tra lại: ");
            }
        } while (size < 1);
        return size;
    }

    private static void displayArray(int[] arrOne, String target) {
        System.out.print(target);
        System.out.print(Arrays.toString(arrOne));
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

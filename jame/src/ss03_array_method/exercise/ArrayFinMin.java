package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFinMin {


    public static int minValue(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size =  inputPositive(sc,"nhập vào chiều dài của mảng: ");


        int[] arrOne = new int[size];
        createArray(sc, arrOne);


        System.out.print("\nmảng vừa nhập: ");
        System.out.print(Arrays.toString(arrOne));

        int index = minValue(arrOne);
        System.out.println("Phần tử nhỏ nhất của mảng: " + arrOne[index]);
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
}


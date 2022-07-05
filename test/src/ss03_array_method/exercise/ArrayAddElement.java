package ss03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = inputPositive(sc,"nhập vào chiều dài của mảng: ");

        int[] arrNumber = new int[size];
        createArray(sc, arrNumber);

        System.out.print("mảng vừa nhập: ");
        System.out.print(Arrays.toString(arrNumber));

        System.out.println("nhập vào phần tử cần thêm: ");
        int value = sc.nextInt();
        System.out.println("Nhập vào vị trí cần thêm: ");
        int index;
        boolean isNotIndex;
        do {
            index = sc.nextInt();
            isNotIndex = index < 0 || index >= arrNumber.length;
            if (isNotIndex) {
                System.out.println("Vị trí cần thêm bị sai, yêu cầu nhập lại: ");
            }
        } while (isNotIndex);


        arrNumber = addElement(arrNumber, value, index);

        System.out.print("mảng sau khi thêm: ");
        System.out.print(Arrays.toString(arrNumber));

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

    private static void createArray(Scanner sc, int[] arrNumber) {
        for (int i = 0; i < arrNumber.length; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + " : ");
            arrNumber[i] = sc.nextInt();
        }
    }

    public static int[] addElement(int[] arr, int val, int index) {

        int[] arrNew = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }

        arrNew[index] = val;

        for (int i = index + 1; i < arrNew.length; i++) {
            arrNew[i] = arr[i - 1];
        }

        return arrNew;

    }
}

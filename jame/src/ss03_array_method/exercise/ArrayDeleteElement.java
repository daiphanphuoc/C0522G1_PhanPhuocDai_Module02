package ss03_array_method.exercise;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeleteElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = inputPositive(sc,"nhập vào chiều dài của mảng: ");


        int[] arrNumber = new int[size];
        createArray(sc,  arrNumber);

        System.out.print("mảng vừa nhập: ");
        System.out.print(Arrays.toString(arrNumber));

        System.out.println("nhập vào phần tử cần xóa: ");
        int value=sc.nextInt();

        arrNumber=deleteElement(arrNumber,value);

        System.out.print("mảng sau khi xóa: ");
        System.out.print(Arrays.toString(arrNumber));

    }

    private static void createArray(Scanner sc, int[] arrNumber) {
        for (int i = 0; i < arrNumber.length; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + " : ");
            arrNumber[i] = sc.nextInt();
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

    public static int[] deleteElement(int[] arr, int val) {

        int[] arrNew = new int[arr.length - 1];
        int indexDel = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                indexDel = i;
                break;
            }
        }

        if (indexDel >= 0) {
            for (int i = indexDel; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;

            for (int j = 0; j < arr.length - 1; j++) {
                arrNew[j] = arr[j];
            }
            return arrNew;
        }

        return arr;

    }
}

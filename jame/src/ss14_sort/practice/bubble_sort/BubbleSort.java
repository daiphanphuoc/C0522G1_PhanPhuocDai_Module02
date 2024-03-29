package ss14_sort.practice.bubble_sort;

import org.jetbrains.annotations.NotNull;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }


   /* public static void bubbleSort(int @NotNull [] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {

            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {

                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }
*/
    private static void bubbleSort(int @NotNull [] arr) {
        int length = arr.length;
        boolean isNext = true;
        for (int i = 0; i < length-1 && isNext; i++) {
            isNext = false;
            for (int j = length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isNext = true;
                }

            }
        }
    }
}

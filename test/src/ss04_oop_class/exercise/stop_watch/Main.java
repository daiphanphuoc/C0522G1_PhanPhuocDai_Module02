package ss04_oop_class.exercise.stop_watch;

import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        long[] arr = new long[100000];
        StopWatch stopWatch = new StopWatch();

        createArrayRandom(arr);

        stopWatch.setStarTime();
        bubbleSort(arr);
        stopWatch.setEndTime();

        System.out.println("Time run bubble sort: " +  stopWatch.getElapsedTime());

        createArrayRandom(arr);

        stopWatch.setStarTime();
        selectionSort(arr);
        stopWatch.setEndTime();

        System.out.printf("Time run selection sort: %d\n",  stopWatch.getElapsedTime());

        createArrayRandom(arr);

        stopWatch.setStarTime();
        insertionSort(arr);
        stopWatch.setEndTime();

        System.out.printf("Time run insertion sort: %d\n",  stopWatch.getElapsedTime());

        long[] arr1 = new long[100000000];
        createArrayRandom(arr1);

        stopWatch.setStarTime();
        quickSort(arr1,0,arr1.length-1);
        stopWatch.setEndTime();

        System.out.printf("Time run quick sort: %d\n", stopWatch.getElapsedTime());

    }

    private static void createArrayRandom(long @NotNull [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.round(Math.random() * 1000000000000000000l - 100000000000000000l);
        }
    }

    private static void bubbleSort(long @NotNull [] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
        }
    }

    private static void insertionSort(long @NotNull [] arr) {
        int length = arr.length;
        int i;
        int pos;
        long temp;

        for (i = 1; i < length; i++) {

            temp = arr[i];
            pos = i - 1;

            while (pos >= 0 && arr[pos] > temp) {
                arr[pos + 1] = arr[pos];
                pos--;
            }

            arr[pos + 1] = temp;//chèn
        }
    }


    private static void selectionSort(long @NotNull [] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                long temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }

        }
    }

    public static long[] quickSort(long[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int mid = (left + right) / 2;
        long temp = arr[mid];
        int i = left;
        int j = right;

        do {
            while (arr[i] < temp) {
                i++;
            }

            while (arr[j] > temp) {
                j--;
            }

            if (i <= j) {
                long t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }

        } while (i <= j);

        if (left < j) {
            return quickSort(arr, left, j);
        }

        if (right > i) {
            return quickSort(arr, i, right);
        }

        return arr;
    }
}

package ss14_sort.exercise.insertion_sort;

public class InsertionSort {

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i; j > 0 && key < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = key;
        }
    }

    public static void main(String[] args) {
        int [] arr={1,5,3,-7,-3,8,23};
        insertionSort(arr);
        for(int i:arr){
            System.out.print(i+"\t");
        }

    }
}

package ss13_search.exercise.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int []  arr={1,2,5,10,20,50,100,200,500,1000};
        System.out.println(binarySearch(arr,1000,0,arr.length-1));
        System.out.println(binarySearch(arr,1,0,arr.length-1));
        System.out.println(binarySearch(arr,10,0,arr.length-1));
        System.out.println(binarySearch(arr,0,0,arr.length-1));
        System.out.println(binarySearch(arr,1001,0,arr.length-1));
    }

    public static int   binarySearch(int [] arr, int key, int left, int right){
        if (right<left){
            return -1;
        }

        int mid=(left+right)/2;

        if(key==arr[mid]){
            return mid;
        }

        if(key<arr[mid]){
            return binarySearch(arr, key, left, mid-1);
        }

        return binarySearch(arr, key, mid+1, right);
    }
}

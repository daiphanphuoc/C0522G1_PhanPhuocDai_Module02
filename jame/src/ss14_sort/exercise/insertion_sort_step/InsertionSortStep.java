package ss14_sort.exercise.insertion_sort_step;

import java.util.Scanner;

public class InsertionSortStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = Integer.parseInt(scanner.nextLine());

        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            System.out.print("element " + (i + 1) + " : ");
            list[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }

        System.out.println("\nBegin sort processing...");
        insertionSort(list);
        for (int i : list) {
            System.out.print(i + "\t");
        }
    }

    private static void insertionSort(int[] list) {

        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            System.out.println("key = " + key);
            int j = i;
            for (; j > 0; j--) {
                System.out.println("so sánh " + key + " và " + list[j - 1]);
                if (key < list[j - 1]) {
                    list[j] = list[j - 1];
                    System.out.println("dời " + list[j - 1] + " về sau 1  ô");
                } else {
                    break;
                }
            }
            System.out.println("chèn key = " + key + " vào vị trí " + (j)+'\n');
            list[j] = key;

        }
    }
}

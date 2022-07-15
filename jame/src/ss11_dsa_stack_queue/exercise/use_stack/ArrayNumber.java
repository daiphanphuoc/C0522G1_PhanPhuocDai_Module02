package ss11_dsa_stack_queue.exercise.use_stack;

import java.util.Arrays;
import java.util.Stack;

public class ArrayNumber {
    public static void main(String[] args) {
        reverseArrNumber();
        reverseString();
    }

    private static void reverseArrNumber() {
        int[] arrNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 23};
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < arrNumber.length; i++) {
            integerStack.add(arrNumber[i]);
            System.out.print(arrNumber[i] + "\t");
            arrNumber[i] = 0;
        }

        int index = 0;
        while (!integerStack.isEmpty()) {
            arrNumber[index++] = integerStack.pop();
        }

        System.out.println();
        System.out.println(Arrays.toString(arrNumber));
    }

    private static void reverseString() {
        String str = "Phan Phước Đại";
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(str.substring(i, i + 1));
        }
        System.out.println(str);
        str = "";
        while (!stringStack.isEmpty()) {
            str += stringStack.pop();
        }
        System.out.println(str);

    }


}

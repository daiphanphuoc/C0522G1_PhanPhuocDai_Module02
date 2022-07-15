package ss11_dsa_stack_queue.exercise.decimal_to_binary;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 5;

        Stack<Integer> binary = new Stack<>();
        int temp = decimal;
        while (temp > 0) {
            binary.push(temp % 2);
            temp /= 2;
        }

        System.out.print(decimal + " đổi thành nhị phân: ");
        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }
}

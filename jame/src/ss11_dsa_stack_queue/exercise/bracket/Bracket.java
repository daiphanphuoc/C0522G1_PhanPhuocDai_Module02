package ss11_dsa_stack_queue.exercise.bracket;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào biểu thức toán học");
        String sym = sc.nextLine();

        System.out.println(isSym(sym));
    }

    private static boolean isSym(String sym) {
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < sym.length(); i++) {
            if ("(".equals(sym.substring(i, i + 1))) {
                stringStack.add("(");
            } else if (")".equals(sym.substring(i, i + 1))) {
                if (stringStack.isEmpty()) {
                    return false;
                }
                stringStack.pop();
            }
        }
        return stringStack.isEmpty();
    }
}

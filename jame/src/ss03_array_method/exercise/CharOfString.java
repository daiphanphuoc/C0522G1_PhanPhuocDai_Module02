package ss03_array_method.exercise;

import java.util.Scanner;

public class CharOfString {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào 1 chuỗi: ");
        String str = sc.nextLine();

        char c = inputCharacter(sc);

        int count ;

        count = countCharOfString(str, c);

        System.out.printf(" ký tự '%c' xuất hiện %d lần trong chuỗi '%s'", c, count, str);
    }

    private static int countCharOfString(String str, char c) {
        int count =0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static char inputCharacter(Scanner sc) {
        char c;
        System.out.println("Nhập vào 1 ký tự:");
        c = sc.nextLine().charAt(0);
        return c;
    }
}

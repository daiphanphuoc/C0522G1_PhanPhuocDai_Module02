package ss13_search.exercise.consecutive_string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ConsecutiveString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi:");
        String str = sc.nextLine();

        ArrayList<Character> max = new ArrayList<>();
        ArrayList<Character> temp = new ArrayList<>();
        temp.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= str.charAt(i - 1)) {
                temp.clear();
            }

            temp.add(str.charAt(i));

            if (temp.size() > max.size()) {
                max.clear();
                max.addAll(temp);
            }

        }

        System.out.println(max);

    }
}

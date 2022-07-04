package ss03_array_method.exercise;

import java.util.Scanner;

public class CharOfString {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào 1 chuỗi: ");
        String str = sc.nextLine();

        System.out.println("Nhập vào 1 ký tự:");
        char c= sc.nextLine().charAt(0);

        int count=0;

        for(int i=0; i<str.length();i++){
            if (c==str.charAt(i)){
                count++;
            }
        }

        System.out.printf(" ký tự '%c' xuất hiện %d lần trong chuỗi '%s'",c,count,str);
    }
}

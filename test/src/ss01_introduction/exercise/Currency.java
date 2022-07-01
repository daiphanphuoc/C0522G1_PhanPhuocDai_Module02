package ss01_introduction.exercise;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào tiền usd cần đổi: ");
        double  usd = sc.nextDouble();

        System.out.println("nhập tỷ giá vnd/usd: ");
        double rate = sc.nextDouble();

        double vnd;
        vnd= usd*rate;
        System.out.printf("%10.2f usd = %15.2f vnd",usd,vnd);
    }
}

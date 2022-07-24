package libs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputUtil {
    public static String getString(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        return sc.nextLine();
    }

    public static boolean getBoolean(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        return Boolean.parseBoolean(sc.nextLine());
    }

    public static double getDouble(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        double d;
        while (true) {
            try {
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return d;

    }

    public static int getInt(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return n;

    }

    public static Date getDate(String target){
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        Date date;
        DateFormat df=new  SimpleDateFormat("dd/MM/yyyy");
        String temp;
        while (true) {
            try {
                temp = sc.nextLine();
                date=df.parse(temp);
                break;
            } catch ( ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return date;

    }
}

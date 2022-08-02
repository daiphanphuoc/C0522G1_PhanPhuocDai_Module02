package libs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        double d;
        while (true) {
            try {
                System.out.print(target);
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return d;

    }

    public static int getInt(String target) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            try {
                System.out.print(target);
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return n;

    }

    public static Date getDate(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        Date date;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String temp;
        while (true) {
            try {
                temp = sc.nextLine();
                date = df.parse(temp);
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.print("");            }
        }
        return date;

    }

    public static LocalDate getLocalDate(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        LocalDate date;
        /*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");*/
        String temp;
        while (true) {
            try {
                temp = sc.nextLine();
                date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }

        }
        return date;

    }


   /*
    public static String getNameStandard(String str) {
        str = str.toLowerCase().trim();
        str = str.replaceAll("[ ]+", " ");
        String[] arrStr = str.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        if (arrStr.length > 1) {
            for (String s : arrStr) {
                stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }
*/
}

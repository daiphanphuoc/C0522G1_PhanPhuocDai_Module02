package exercise.student_management_file.until;

import exercise.student_management_file._exception.NameRegexException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class UtilInput {

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
    public static LocalDate getTime(String target){
        Scanner sc = new Scanner(System.in);
        LocalDate date;
        String temp;
        while (true) {
            try {
                System.out.print(target);
                temp = sc.nextLine();
                date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch ( DateTimeParseException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Date getDate(String target) {
        Scanner sc = new Scanner(System.in);

        Date date;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String temp;
        while (true) {
            try {
                System.out.print(target);
                temp = sc.nextLine();
                date = df.parse(temp);
                break;
            } catch (ParseException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return date;

    }

    public static String getNameStandard(String str) throws NameRegexException {
        final String NAME_REGEX = "([^0-9 ]{2,6}[ ]){1,3}[^0-9 ]{1,6}";
        /**str=str.toLowerCase().trim();
         str=str.replaceAll("[ ]+"," ");*/
        StringBuilder stringBuilder = new StringBuilder();
        if (str.matches(NAME_REGEX)) {
            String[] arrStr = str.split(" ");
            for (String s : arrStr) {
                stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            throw new NameRegexException("Nhập tên sai định dạng!!!");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LocalDate d=getTime("Nhập vào ngày tháng theo định dạng dd/mm/yyyy");
        System.out.println(d);
    }
}

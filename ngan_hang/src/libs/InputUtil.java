package libs;

import exception.MaTaiKhoanException;
import exception.NameStandardException;
import org.jetbrains.annotations.NotNull;
import service.regex.MaTaiKhoanRegex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        String temp;
        while (true) {
            try {
                temp = sc.nextLine();
                date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }catch (IllegalArgumentException| DateTimeParseException e){
                e.printStackTrace();
            }

        }
        return date;

    }

public static String nhapMaTaiKhoan(String target){
    //final  String REGEX_TAIKHOAN = "^TK(TK|TT)\\-[\\d]{4}$";
    String id;
    while (true) {
        try {
            id = getString(target);
            if (!(new MaTaiKhoanRegex().validate(id))) {
                throw new MaTaiKhoanException(" Mã tài khoản không đúng định dạng '(TKTK|TKTT)-yyyy'.");
            }
            break;
        } catch (MaTaiKhoanException e) {
            e.printStackTrace();
            System.out.print("");
        }
    }
    return id;
}

    /**
     * Nhập tên theo chuẩn
     */

    public static @NotNull String inputNameStandard(String target) {
        final  String NAMEREGEX = "^([ ]*[^\\d!@#$%^&*()_+./-]{2,6}[ ]+){1,3}[^\\d!@#$%^&*()_+./-]{1,6}[ ]*$";

        String[] temp;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String name = getString(target);

                if (!name.matches(NAMEREGEX)) {
                    throw new NameStandardException("Nhập tên không đúng định dạng,  ví dụ Nguyễn Văn A.");
                }

                temp = name.toLowerCase().split(" ");
                for (String s : temp) {
                    stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
                }

                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;

            } catch (NameStandardException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }

}

package exercise.student_management_file.until;

import java.util.Scanner;

public class UtilInput {

    public static String getString(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        String str = sc.nextLine();
        return str;
    }

    public static boolean getBoolean(String target) {
        Scanner sc = new Scanner(System.in);
        System.out.print(target);
        boolean b = Boolean.parseBoolean(sc.nextLine());
        return b;
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
}

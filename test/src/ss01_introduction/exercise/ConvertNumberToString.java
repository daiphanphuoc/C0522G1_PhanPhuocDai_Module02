package ss01_introduction.exercise;

import java.util.Scanner;

public class ConvertNumberToString {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào một số: ");
        number = sc.nextInt();
        int unit = number % 10;
        int dozen = number / 10 % 10;
        int hundred = number / 100;
        String str = "";
        if (hundred > 0) {
            str = str + readNumberUnit(hundred) + " hundred  ";
        }
        if (dozen > 1) {
            if(hundred>0){
                str = str  + "and " + readNumberDozen(dozen) + " " + readNumberUnit(unit);
            }else{
                str = str + readNumberDozen(dozen) + " " + readNumberUnit(unit);
            }

        } else if (dozen == 0) {
            if(unit>0){
                str = str + " and " + readNumberUnit(unit);
            }

        }else {
            switch (unit) {
                case 1:
                    str = str + " and eleven";
                case 2:
                    str = str + " and twelve";
                case 3:
                    str = str + " and thirteen";
                case 4:
                    str = str + " and fourteen";
                case 5:
                    str = str + " and fifteen";
                case 6:
                    str = str + " and sixteen";
                case 7:
                    str = str + " and seventeen";
                case 8:
                    str = str + " and eighteen";
                case 9:
                    str = str + " and nineteen";
                case 0:
                    str = str + " and ten";
            }
        }
        System.out.println(str);

    }

    public static String readNumberUnit(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 0:
                return "";
        }
        return "";
    }

    public static String readNumberDozen(int number) {
        switch (number) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventies";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
        }
        return "";
    }
}

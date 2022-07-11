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
            str = str + readNumberUnit(hundred) + " hundred and ";
        }
        if (dozen > 1) {
            if(hundred>0){
                str = str   + readNumberDozen(dozen) + " " + readNumberUnit(unit);
            }else{
                str = str + readNumberDozen(dozen) + " " + readNumberUnit(unit);
            }

        } else if (dozen == 0) {
            if(unit>0){
                str = str  + readNumberUnit(unit);
            }

        }else {
            switch (unit) {
                case 1:
                    str = str + " eleven";
                    break;
                case 2:
                    str = str + " twelve";
                    break;
                case 3:
                    str = str + " thirteen";
                    break;
                case 4:
                    str = str + " fourteen";
                    break;
                case 5:
                    str = str + " fifteen";
                    break;
                case 6:
                    str = str + " sixteen";
                    break;
                case 7:
                    str = str + " seventeen";
                    break;
                case 8:
                    str = str + " eighteen";
                    break;
                case 9:
                    str = str + " nineteen";
                    break;
                case 0:
                    str = str + " ten";
                    break;
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

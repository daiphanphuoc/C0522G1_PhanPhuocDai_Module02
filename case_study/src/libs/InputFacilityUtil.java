package libs;

import _exception.AmountPersonException;
import _exception.AreaException;
import _exception.NameStandardException;
import _exception.NumberPositionException;
import regex.NameFacilityRegex;

import static libs.InputUtil.*;

public class InputFacilityUtil {
    public static String inputString(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String name = getString(target);
                if ((new NameFacilityRegex()).validate(name)) {
                    name = name.toLowerCase().trim();
                    name = name.replaceAll("[ ]+", " ");
                    stringBuilder.append(name.substring(0, 1).toUpperCase()).append(name.substring(1));
                } else {
                    throw new NameStandardException("Nhập không đúng định dạng ");
                }
                break;
            } catch (NameStandardException e) {
                e.printStackTrace();
                System.out.print("");
            }

        }
        return stringBuilder.toString();
    }

    public static double inputArea(String target) {
        double leasedArea;
        while (true) {
            try {
                leasedArea = getDouble(target);
                if (leasedArea < 30) {
                    throw new AreaException(" Diện tich phải lớn hơn 30");
                }
                break;
            } catch (AreaException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return leasedArea;

    }

    public static double inputRentalCosts(String target) {
        double rentalCosts;
        while (true) {
            try {
                rentalCosts = getDouble(target);
                if (rentalCosts <= 0) {
                    throw new NumberPositionException("Chi phí thuê phải là số dương");
                }
                break;
            } catch (NumberPositionException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return rentalCosts;
    }

    public static int inputMaxPerson(String target) {
        int max;
        while (true) {
            try {
                max = getInt(target);
                if (max < 1 || max > 19) {
                    throw new AmountPersonException("Số người tối đa phải lớn hơn 0 và nhỏ hơn 20");
                }
                break;
            } catch (AmountPersonException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return max;
    }

    public static int inputFloor(String target) {
        int floor;
        while (true) {
            try {
                floor = getInt(target);
                if (floor < 1) {
                    throw new NumberPositionException("Số tần phải là số dương!!!");
                }
                break;
            } catch (NumberPositionException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return floor;
    }


}

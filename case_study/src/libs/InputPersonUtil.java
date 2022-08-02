package libs;

import _exception.*;
import _exception.facility.DegreeException;
import _exception.facility.PositionException;
import _exception.person.*;
import org.jetbrains.annotations.NotNull;
import regex.*;

import java.util.Date;

import static libs.InputUtil.getDate;
import static libs.InputUtil.getString;

public class InputPersonUtil {
    /**
     * Nhập tên theo chuẩn
     */
    public static @NotNull String inputNameStandard(String target) {
        String[] temp;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String name = getString(target);

                if (!(new NameStandardRegex()).validate(name)) {
                    throw new NameStandardException("Nhập tên không đúng định dạng.");
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

    /**
     * Nhập ngày sinh cho nhân viên, phải đủ 18 tuổi và không quá 60 tuổi
     */
    public static Date inputDateOfEmployee(String target) {
        Date birthday;
        while (true) {
            try {
                birthday = getDate(target);
                double old = ((new Date()).getTime() - birthday.getTime())/ 31557600000L;
                if (old < 18 || old > 60) {
                    throw new BirthdayException("Nhân viên phải đủ 18 tuổi và không quá 60 tuổi!!!");
                }
                break;
            } catch (BirthdayException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return birthday;
    }

    /**
     * Nhập ngày sinh cho khách hàng, phải đủ 18 tuổi và không quá 100 tuổi
     */
    public static Date inputDateOfCustomer(String target) {
        Date birthday;
        while (true) {
            try {
                birthday = getDate(target);
                double old = ((new Date()).getTime() - birthday.getTime())/ 31557600000L;
                if (old < 18 || old > 100) {
                    throw new BirthdayException("Khách phải đủ 18 tuổi và không quá 100 tuổi!!!");
                }
                break;
            } catch (BirthdayException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return birthday;
    }

    /**
     * Nhập Email đúng định dạng
     */
    public static @NotNull String inputEmail(String target) {
        String email;
        while (true) {
            email = getString(target);
            try {
                if (!(new EmailRegex()).validate(email)) {
                    throw new EmailException("Nhập email không đúng định dạng.");
                }
                break;
            } catch (EmailException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return email.toLowerCase();
    }

    /**
     * Nhập số điện thoại đúng định dạng(84|0)(xxxxxxxxx)
     */
    public static @NotNull String inputPhone(String target) {
        String phone;
        while (true) {
            phone = getString(target);
            try {
                if (!(new NumberPhoneRegex()).validate(phone)) {
                    throw new PhoneException("Nhập số phone không đúng định dạng(84|0)(xxxxxxxxx).");
                }
                break;
            } catch (PhoneException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return phone;
    }


    /**
     * Nhập mã số khách hàng đúng định dạng E-xxxx
     */
    public static @NotNull String inputIDCustomer(String target) {
        String iDCustomer;
        while (true) {
            iDCustomer = getString(target);
            try {
                if (!(new IDCustomerRegex()).validate(iDCustomer)) {
                    throw new IDCustomerException("Nhập mã số khách hàng không đúng định dạng E-xxxx.");
                }
                break;
            } catch (IDCustomerException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return iDCustomer;
    }

    /**
     * Nhập mã số nhân viên đúng định dạng C-xxxx
     */
    public static @NotNull String inputIDEmployee(String target) {
        String iDEmployee;
        while (true) {
            iDEmployee = getString(target);
            try {
                if (!(new IDEmployeeRegex()).validate(iDEmployee)) {
                    throw new IDEmployeeException("Nhập mã số nhân viên không đúng định dạng C-xxxx.");
                }
                break;
            } catch (IDEmployeeException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return iDEmployee;
    }

    /**
     * Nhập mã số công dân đúng định dạng có 12 số
     */
    public static @NotNull String inputIDCitizen(String target) {
        String iDCitizen;
        while (true) {
            iDCitizen = getString(target);
            try {
                if (!(new IDCitizenRegex()).validate(iDCitizen)) {
                    throw new IDCitizenException("Nhập mã số công dân không đúng định dạng có 12 số.");
                }
                break;
            } catch (IDCitizenException e) {
                e.printStackTrace();
                System.out.print("");
            }
        }
        return iDCitizen;
    }

    /**
     * INTERMEDIATE   -->  Trung cấp
     * COLLEGE -->Cao đẳng
     * UNDERGRADUATE -->Đại học
     * GRADUATE  -->  sau đại học
     */
    private enum Degree {
        INTERMEDIATE,
        COLLEGE,
        UNDERGRADUATE,
        GRADUATE;

        public static @NotNull String getDegree(@NotNull Degree degree)  {
            switch (degree) {
                case COLLEGE:
                    return "Đại học";
                case GRADUATE:
                    return "sau Đại học";
                case INTERMEDIATE:
                    return "Trung cấp";
                case UNDERGRADUATE:
                    return "Cao đẳng";
                default:
                    return "";
            }
        }

    }

    /**
     * INTERMEDIATE   -->  Trung cấp
     * COLLEGE -->Cao đẳng
     * UNDERGRADUATE -->Đại học
     * GRADUATE  -->  sau đại học
     */
    public static @NotNull String inputDegree(String degree) throws IllegalArgumentException {
        degree = degree.toUpperCase().trim();
        return Degree.getDegree(Degree.valueOf(degree));
    }


    /**
     * RECEPTIONIST -->Lễ tân
     * WAITER --> Phục vụ
     * SPECIALIST -->  Chuyên viên
     * SUPERVISOR -->Giám sát
     * MANAGER --> Quản lý
     * DIRECTOR --> Giám đốc
     */
    private enum Position {
        RECEPTIONIST,
        WAITER,
        SPECIALIST,
        SUPERVISOR,
        MANAGER,
        DIRECTOR;

        public static @NotNull String getPosition(@NotNull Position position)  {
            switch (position) {
                case RECEPTIONIST:
                    return "Lễ tân";
                case WAITER:
                    return "Phục vụ";
                case SPECIALIST:
                    return "Chuyên viên";
                case SUPERVISOR:
                    return "Giám sát";
                case MANAGER:
                    return "Quản lý";
                case DIRECTOR:
                    return "Giám đốc";
                default:
                    return "";
            }
        }
    }

    /**
     * RECEPTIONIST -->Lễ tân
     * WAITER --> Phục vụ
     * SPECIALIST -->  Chuyên viên
     * SUPERVISOR -->Giám sát
     * MANAGER --> Quản lý
     * DIRECTOR --> Giám đốc
     */
    public static @NotNull String inputPosition(String position) throws IllegalArgumentException {
        position = position.toUpperCase().trim();
        return Position.getPosition(Position.valueOf(position));
    }

    /**
     * Diamond: Kim cương
     * Platinium: Bạch kim
     * Gold: Vàng
     * Silver: Bạc
     * Member: Thành viên
     */
    private enum CustomerType {
        DIAMOND,
        PLATINIUM,
        GOLD,
        SILVER,
        MEMBER;
        public static @NotNull String getCustomerType(@NotNull CustomerType customerType)  {
            switch (customerType){
                case MEMBER:return "Thành viên";
                case SILVER:return "Bạc";
                case GOLD:return "Vàng";
                case PLATINIUM:return "Bạch kim";
                case DIAMOND: return "Kim cương";
                default:return "";
            }
        }
    }

    /**
     * Diamond: Kim cương
     * Platinium: Bạch kim
     * Gold: Vàng
     * Silver: Bạc
     * Member: Thành viên
     */
    public static @NotNull String inputCustomerType(String customerType) throws IllegalArgumentException {
        customerType=customerType.toUpperCase().trim();
        return CustomerType.getCustomerType(CustomerType.valueOf(customerType));
    }
}

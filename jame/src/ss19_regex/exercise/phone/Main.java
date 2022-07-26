package ss19_regex.exercise.phone;

import exercise.student_management_file.until.UtilInput;

public class Main {
    public static void main(String[] args) {
        PhoneRegex phoneRegex=new PhoneRegex();
        System.out.println(phoneRegex.validate(UtilInput.getString(
                "Nhập vào số điện thoại theo định dạng   (xx)-(0xxxxxxxxx)")));
    }
}

package exercise.student_management_list.until;

import org.jetbrains.annotations.NotNull;

public class Until {
    public static boolean approximateComparison(String str1, String str2) {
        str1=str1.toLowerCase().trim();
        str2=str2.toLowerCase().trim();

        if(str1.equals(str2)){
            return true;
        }

        String[] arrStringOne = str1.split(" ");
        String[] arrStringTwo = str2.split(" ");

        for (int i = 0; i < arrStringOne.length; i++) {
            for (int j = 0; j < arrStringTwo.length; j++) {
                if (arrStringOne[i].equals(arrStringTwo[j])&& arrStringOne[i].length()>1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int compareString(@NotNull String str1, @NotNull String str2){

        int length= Math.min(str1.length(), str2.length());
        for (int i=0;i<length;i++){

            if(str1.charAt(i)>str2.charAt(i)){
                return 1;
            }

            if(str1.charAt(i)<str2.charAt(i)){
                return -1;
            }
        }

        if(str1.length()==str2.length()){
            return 0;
        }

        if(str1.length()>str2.length()){
            return 1;
        }

        return -1;
    }
}

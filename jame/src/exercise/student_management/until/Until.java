package exercise.student_management.until;

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
}

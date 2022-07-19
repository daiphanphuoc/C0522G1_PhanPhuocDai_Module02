package ss13_search.exercise.max_string;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Scanner;

public class StringMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        String max = getString(str);
        System.out.println(max);
    }


    @NotNull
    private static String getString(String str) {
        String max="";
        for(int j = 0; j< str.length(); j++) {
            String temp = str.substring(j, j+1);

            for (int i = j+1; i < str.length() - 1; i++) {
                if (str.charAt(i) > temp.charAt(temp.length() - 1)) {
                    temp += str.substring(i, i + 1);
                }
            }
            if(temp.length()>=max.length()){
                max=temp;

            }
            temp="";
        }
        return max;
    }

    @NotNull
    private static LinkedList<Character> searchString(String str) {
        LinkedList<Character> max=new LinkedList<>();
        for(int j = 0; j< str.length(); j++) {
            LinkedList<Character> temp=new LinkedList<>();
           temp.add(str.charAt(j));

            for (int i = j+1; i < str.length() - 1; i++) {
                if (str.charAt(i) > temp.getLast()) {
                    temp.add(str.charAt(i));
                }
            }
            if(temp.size()>max.size()){
                max.clear();
                max.addAll(temp);

            }
            temp.clear();
        }
        return max;
    }
}

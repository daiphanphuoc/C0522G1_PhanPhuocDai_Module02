package ss11_dsa_stack_queue.exercise._string_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Word {
    public void countWord(String str){
        String[] word =str.toLowerCase().split(" ");
        System.out.println(Arrays.toString(word));

        Map<String, Integer> stringMap=new HashMap<>();

        for (int i=0; i<word.length;i++){
            if(stringMap.containsKey(word[i])){
                stringMap.replace(word[i],stringMap.get(word[i])+1);
            }
            else{
                stringMap.put(word[i],1);
            }
        }

        System.out.println(stringMap);
    }

    public static void main(String[] args) {
        Word words=new Word();
        words.countWord("Dai phan phuoc Dai phan phuoc Dai phan phuoc");
    }
}

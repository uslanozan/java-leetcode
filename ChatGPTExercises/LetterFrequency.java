package ChatGPTExercises;

import java.util.HashMap;
import java.util.Map;

/* 
2️⃣ Most Repeated Character

Take a string from the user, calculate which character occurs the most using Map<Character, Integer>.
*/

public class LetterFrequency {
    public static void main(String[] args) {
        String input1 = "banana";
        String input2 = "Outlier";
        String input3 = "success";
        countLetters(input1);
        countLetters(input2);
        countLetters(input3);
    }

    public static void countLetters(String word){

        Map<Character, Integer> letters = new HashMap <>();
        String regex = "[,\\.\\s!]";
        word.split(regex);

        for (char a : word.toCharArray()) {
            if(a == ' '){
                continue;
            }
            if(letters.containsKey(a)){
                letters.put(a, letters.get(a) + 1);
            }
            else{
                letters.put(a, 1);
            }
        }    
        
        System.out.println(letters);    
    }
    
}

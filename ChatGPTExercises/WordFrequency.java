package ChatGPTExercises;

import java.util.HashMap;
import java.util.Map;

/*
1️⃣ Word Frequency Analysis

Take a paragraph from the user and calculate the number of times each word occurs.
Save the result as Map<String, Integer>.
*/

public class WordFrequency{


    public static void main(String[] args){
        String input1 = "Java is a programming language. Java is powerful. Java is widely used.";
        String input2 = "Outlier tasks are challenging. Outlier helps improve AI. Outlier is great!";
        String input3 = "Machine learning is a branch of artificial intelligence. Machine learning is used in many fields. AI and machine learning are transforming the world.";
        countWords(input1);
        countWords(input2);
        countWords(input3);
    }

    public static void countWords(String paragraph){

        Map<String, Integer> words = new HashMap <>();
        //Regex for: spaces,.!
        String regex = "[,\\.\\s!]";
        String []array = paragraph.toLowerCase().split(regex);

        for (String s : array) {
            //System.out.println(s);
            if (s.trim().isEmpty()) {
                continue;
            }
            if(words.containsKey(s)){
                words.put(s, words.get(s) + 1);
            }else{
            words.put(s, 1);
            }
        }
        System.out.println(words);
    }
}
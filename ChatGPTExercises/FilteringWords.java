import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3️⃣ Filtering and Transforming in List

There are words like "apple", "banana", "cherry", "blueberry", "apricot" in List<String>.
Take the ones that start with "a" and convert all the letters to uppercase.
Return the result in a new List<String>.
 */

public class FilteringWords {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "apricot");
        List<String> words2 = Arrays.asList("avocado", "grape", "melon", "apricot", "mango");
        List<String> words3 = Arrays.asList();
        List<String> words4 = Arrays.asList("Apple", "banana", "Apricot", "avocado");
        
        filterWords(words, 'b');
        filterWords(words, 'a');
        filterWords(words2, 'a');
        filterWords(words3, 'a');
        filterWords(words4, 'a');
    }

    public static void filterWords(List<String> list, Character filter){
        List<String> newList = new ArrayList<>();

        for (String word : list) {
            if(word.charAt(0) == filter){
                newList.add(word);
            }
        }
        System.out.println(newList);
    }
}

package ChatGPTExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 4️⃣ Merge Two Different Lists and Get Unique Elements

There are two different List<Integer>:

List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

Merge these lists but return a Set<Integer> containing only unique elements.
 */

public class Merge2Lists {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> list3 = Arrays.asList(10, 20, 30, 40);
        List<Integer> list4 = Arrays.asList(30, 40, 50, 60);
        
        List<Integer> list5 = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> list6 = Arrays.asList(1, 1, 2, 2, 3, 3);

        List<Integer> list7 = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> list8 = Arrays.asList(1, 1, 2, 2, 3, 3);

        List<Integer> list9 = Arrays.asList();
        List<Integer> list10 = Arrays.asList();

        mergeLists(list1, list2);
        mergeLists(list3, list4);
        mergeLists(list5, list6);
        mergeLists(list7, list8);
        mergeLists(list9, list10);

    }

    public static void mergeLists(List<Integer> list1, List<Integer> list2){

        // TreeSet is used instead of HashSet because TreeSet sorts by default
        Set<Integer> mergeIntegers = new TreeSet<>();
        mergeIntegers.addAll(list1);
        mergeIntegers.addAll(list2);
           
        System.out.println(mergeIntegers);
    }
}

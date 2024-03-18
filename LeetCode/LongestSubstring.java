package LeetCode;

import java.util.ArrayList;

public class LongestSubstring {

//    Given a string s, find the length of the longest
//            substring
//    without repeating characters.
//
//
//
//            Example 1:
//
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//    Example 2:
//
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> subArray = new ArrayList<>();

        // En uzun benzersiz alt dizi uzunluğu
        int maxLength = 0;

        // String üzerinde ilerlenir
        for (char c : s.toCharArray()) {
            // Karakter alt dizide varsa, alt diziyi temizler
            if (subArray.contains(c)) {
                int index = subArray.indexOf(c);
                subArray.subList(0, index + 1).clear();
            }
            // Karakter alt dizide yoksa, alt diziyi günceller
            subArray.add(c);
            // Güncellenmiş alt dizi uzunluğunu kontrol eder
            maxLength = Math.max(maxLength, subArray.size());
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "dvdf";
        String s5 = " ";
        String s6 = "tmmzuxt";

        System.out.println(lengthOfLongestSubstring(s1)); // Beklenen: 3
        System.out.println(lengthOfLongestSubstring(s2)); // Beklenen: 1
        System.out.println(lengthOfLongestSubstring(s3)); // Beklenen: 3
        System.out.println(lengthOfLongestSubstring(s4)); // Beklenen: 3
        System.out.println(lengthOfLongestSubstring(s5)); // Beklenen: 1
        System.out.println(lengthOfLongestSubstring(s6)); // Beklenen: 5
    }
}

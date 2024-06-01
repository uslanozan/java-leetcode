package LeetCode;

//Given a string s, return the longest palindromic substring in s.
//
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//        Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
//
//
//        Constraints:
//
//        1 <= s.length <= 1000
//        s consist of only digits and English letters.

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        // Eğer stringin uzunluğu 1 ise, direkt stringi döndür.
        if (s.length() == 1)
            return s;

        // Eğer stringin uzunluğu 2 ise, karakterleri karşılaştır ve uygunsa döndür.
        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1))
                return s.substring(0, 1);
            else
                return s;
        }

        // Sonuç olarak en uzun palindromik alt diziyi saklamak için bir değişken.
        String result = "";
        String value;
        int left;
        int right;
        boolean isPalindrome;

        // Tüm alt dizileri oluşturmak için iki döngü.
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                value = s.substring(i, j); // Alt dizi oluşturma.
                left = 0;
                right = value.length() - 1;
                isPalindrome = true;

                // Alt dizinin palindrom olup olmadığını kontrol et.
                while (left < right) {
                    if (value.charAt(left) != value.charAt(right)) {
                        isPalindrome = false; // Eğer eşleşmezse, palindrom değildir.
                        break;
                    }
                    left++;
                    right--;
                }

                // Eğer alt dizi palindrom ise ve mevcut sonuçtan daha uzunsa, sonucu güncelle.
                if (isPalindrome && value.length() > result.length()) {
                    result = value;
                }
            }
        }

        // Eğer hiçbir palindrom bulunmadıysa, ilk karakteri döndür.
        if (result.equals(""))
            return s.substring(0, 1);

        return result; // En uzun palindromik alt diziyi döndür.
    }

    public static void main(String[] args) {
        // Test case'leri çalıştırma ve sonuçları yazdırma.
        String s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforustheli";
        String s2 = "cbbd";
        String s3 = "babad";
        String s4 = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        String s5 = "a0dcbcd";
        String s6 = "abcde";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
        System.out.println(longestPalindrome(s4));
        System.out.println(longestPalindrome(s5));
        System.out.println(longestPalindrome(s6));
    }
}

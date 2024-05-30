package LeetCode;

import java.util.ArrayList;

public class LongestPalindromicSubstring {


    public static String longestPalindrome(String s) {

        String value="";
        String tempValue="";
        int iterator=s.length()-1;

        for(int i=0; i<s.length()-1 ;i++){
            while ((s.charAt(i)!=s.charAt(iterator)) && iterator > i){
                iterator--;
            }
            StringBuilder sb = new StringBuilder(tempValue);
            if(i!=iterator){
                sb.insert(tempValue.length()/2,s.charAt(i));
                sb.insert(tempValue.length()/2,s.charAt(i));

            }else {
                sb.insert(tempValue.length()/2,s.charAt(i));
            }
            tempValue= sb.toString();
            if (value.length() < tempValue.length())
                value=tempValue;
            //iterator=s.length()-1;
            //tempValue="";
        }
        return value;
    }

    public static void main(String[] args) {
        String s1 = "dbaccabx";
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }

}

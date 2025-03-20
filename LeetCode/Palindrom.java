package LeetCode;

//Given an integer x, return true if x is a palindrome , and false otherwise.
//Follow up: Could you solve it without converting the integer to a string?


public class Palindrom {

    public static boolean isPalindrome(int x) {
        //We don't need to check if x is int or long etc.

        int origin=x;
        if (x < 0)
            return false;

        int reverse=0;
        while (x>0){
            reverse=reverse*10+x%10;
            x = x/10;
        }

        return reverse == origin;

    }


    public static void main(String[] args) {
        int a=989;
        System.out.println(isPalindrome(a));

    }
}

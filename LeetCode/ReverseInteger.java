package LeetCode;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
//
//
//Constraints:
//
//        -231 <= x <= 231 - 1

public class ReverseInteger {

    public static int reverse(int x){

        if (x==0) return 0;

        boolean sign=true;
        if (x < 0){
            x=x*-1;
            sign=false;
        }

        StringBuilder value = new StringBuilder();
        int a;
        while(x>0){
            a = x%10;
            value.append(Integer.toString(a));
            x = x / 10;
        }
        String strValue=value.toString();


        try {
            x = Integer.parseInt(strValue);
            return sign ? x : -1 * x;
        } catch (NumberFormatException e) {
            return 0;
        }
    }



    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(a);
        System.out.println(reverse(a));


    }
}

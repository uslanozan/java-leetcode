package LeetCode;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//
//
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Example 2:
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//Example 3:
//
//Input: s = "A", numRows = 1
//Output: "A"
//
//
//Constraints:
//
//        1 <= s.length <= 1000
//s consists of English letters (lower-case and upper-case), ',' and '.'.
//        1 <= numRows <= 1000
public class ZigzagConversion {


    public static String zigzag(String s, int numRows){
        if (numRows == 1) return s;

        StringBuilder value = new StringBuilder();
        int modulus = (2*numRows)-2;
        int len=s.length();

        for (int rowIndex = 0; rowIndex < numRows ; rowIndex++){  // Row sayısı kadar dönmeli
            for (int i=rowIndex; i < len ; i += modulus){   // i kelime boyunca dönecek index
                value.append(s.charAt(i));
                if (rowIndex != 0 && rowIndex != numRows - 1 && i + modulus - 2 * rowIndex < len) {
                    value.append(s.charAt(i + modulus - 2 * rowIndex));
                }
            }
        }
        return value.toString();
    }

    public static void main(String[] args) {
        String test1="PAYPALISHIRING";
        System.out.println(zigzag(test1,4));;


    }
}

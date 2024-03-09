package LeetCode;

import java.util.HashMap;

public class TwoSum {
//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    public static int test(){
        return 1;
    }

    public static int[] twoSum(int[] nums, int target) {
        // Eleman indislerini saklamak için bir HashMap oluşturun
        HashMap<Integer, Integer> map = new HashMap<>();

        // Diziyi dolaşın
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Eğer complement değeri HashMap'te varsa, çözümü bulduk demektir
            if (map.containsKey(complement)) {
                // İndisleri döndür
                return new int[]{map.get(complement), i};
            }

            // Eğer complement değeri bulunamazsa, şu anki elemanı ve indisini HashMap'e ekleyin
            map.put(nums[i], i);
        }



        // Eğer çözüm bulunamazsa
        throw new IllegalArgumentException("Two sum çözümü yok");
    }

    public static void main(String[] args) {
        // Örnek kullanım
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Örnek 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Örnek 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Örnek 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}

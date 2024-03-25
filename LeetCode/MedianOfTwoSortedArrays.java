package LeetCode;//        Example 1:
//
//        Input: nums1 = [1,3], nums2 = [2]
//        Output: 2.00000
//        Explanation: merged array = [1,2,3] and median is 2.
//        Example 2:
//
//        Input: nums1 = [1,2], nums2 = [3,4]
//        Output: 2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

import java.util.ArrayList;
import java.util.Collections;

public class MedianOfTwoSortedArrays {

    static public double findMedianSortedArrays(int[] nums1, int[] nums2){
        ArrayList<Integer> wholeList=new ArrayList<>();
        int m= nums1.length;
        int n= nums2.length;

        for (int j : nums1) {
            wholeList.add(j);
        }

        for (int i : nums2) {
            wholeList.add(i);
        }

        Collections.sort(wholeList);
        int mid1=(n+m)/2;

        double result=0;
        if (wholeList.size()%2==0){
            result = (wholeList.get(mid1)+wholeList.get(mid1-1))/2.0;
            return result;
        }else{
            result=wholeList.get(wholeList.size()/2);
            return result;
        }
    }
// Rıdonun çözümü
//    static public double findMedianSortedArrays(int[] nums1, int[] nums2){
//        int m= nums1.length;
//        int n= nums2.length;
//        int[] wholeList=new int[m+n];
//        if (nums1.length==0){
//            return ((nums2[n/2]+nums2[n/2-(n+1)%2])/2.0);
//        }
//        if (nums2.length==0){
//            return ((nums1[m/2]+nums1[m/2-(m+1)%2])/2.0);
//        }
//        int a =0;
//        int b =0;
//        int index=0;
//        while(b!=m && a!=n ){
//            if(nums1[b]>nums2[a]){
//                wholeList[index]=nums2[a];
//                a++;
//                index++;
//            }else{
//                wholeList[index]=nums1[b];
//                b++;
//                index++;
//            }
//        }
//        if(a==n){
//            for (int i=b;i<m;i++){
//                wholeList[index]=nums1[i];
//                index++;
//            }
//        }
//        if(b==m){
//            for (int i=a;i<n;i++){
//                wholeList[index]=nums2[i];
//                index++;
//            }
//        }
//
//        return (wholeList[(m+n)/2]+wholeList[(m+n)/2-(m+n+1)%2])/2.0;
//
//    }


    public static void main(String[] args) {
        int[] array={1,2};
        int[] array1={3,4};
        System.out.println(findMedianSortedArrays(array,array1));
    }

}
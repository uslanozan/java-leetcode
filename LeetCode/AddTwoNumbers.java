package LeetCode;
import java.util.Iterator;
import java.util.LinkedList;

public class AddTwoNumbers {
//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    /**
     * Tek bağlı liste için tanım.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /* This part for ListNode class on leetcode
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(); // Dummy head kullanarak kodu basitleştiriyoruz.
            ListNode current = dummyHead; // Sonuç bağlı listesindeki mevcut düğümü gösteren işaretçi.
            int carry = 0; // Taşıma bilgisini tutan değişken.

            while (l1 != null || l2 != null) {
                int x = (l1 != null) ? l1.val : 0; // l1'in değeri veya 0.
                int y = (l2 != null) ? l2.val : 0; // l2'nin değeri veya 0.

                int sum = x + y + carry; // Karşılıklı rakamları ve taşımayı topla.
                carry = sum / 10; // Toplamın 10'dan büyük olup olmadığını kontrol et ve taşımayı güncelle.

                current.next = new ListNode(sum % 10); // Yeni bir düğüm oluşturarak sonuç bağlı listesine ekle.
                current = current.next; // İşaretçiyi bir sonraki düğüme taşı.

                if (l1 != null) l1 = l1.next; // l1'i bir sonraki düğüme taşı.
                if (l2 != null) l2 = l2.next; // l2'yi bir sonraki düğüme taşı.
            }

            if (carry > 0) {
                current.next = new ListNode(carry); // Eğer taşıma varsa, yeni bir düğüm oluşturarak ekleyin.
            }

            return dummyHead.next; // Dummy head'in bir sonraki düğümünü (gerçek başlangıcı) döndürün.
        }
    }*/


    public static LinkedList<Integer> l1=new LinkedList<>();
    public static LinkedList<Integer> l2=new LinkedList<>();

    public static LinkedList<Integer> addNumbers(LinkedList<Integer> l1,LinkedList<Integer> l2){
        String val1="";
        String val2="";
        Iterator<Integer> iterator=l1.descendingIterator(); //Iterator starts from end to head.
        Iterator<Integer> iterator2=l2.descendingIterator();
        while (iterator.hasNext()){  //Creating new strings
            val1=val1 + iterator.next().toString() ;
        }
        while (iterator2.hasNext()){
            val2=val2 + iterator2.next().toString() ;
        }
        String value= String.valueOf(Integer.parseInt(val1)+Integer.parseInt(val2));//Convert vals to integer and add
                                                                                      //and then convert again
        LinkedList<Integer> llast=new LinkedList<>();
        for (int a=0;a<value.length();a++){  //Add to new linkedlist
            llast.add(Integer.parseInt(String.valueOf(value.charAt(a))));
        }

        return llast;
    }

    public static void main(String[] args) {
        l1.add(2);
        l1.add(4);
        l1.add(3);

        l2.add(5);
        l2.add(6);
        l2.add(4);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(addNumbers(l1,l2));
    }
}

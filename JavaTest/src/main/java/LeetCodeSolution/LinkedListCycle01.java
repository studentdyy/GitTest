package LeetCodeSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle01 {
    /*
    * 直接用哈希表就完了
    * 用双指针一个慢一个快
    * */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode left = head;
        ListNode right = head.next;
        while(left != right){
            if(right == null || right.next == null){
                return false;
            }
            left = left.next;
            right = right.next.next;
        }
        return true;
    }

    public static boolean hasCycleByHash(ListNode head){
        Set<ListNode> s = new HashSet<ListNode>();
        while(head != null){
            if(!s.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        boolean result = hasCycle(l1);
        System.out.println(result);
    }
}

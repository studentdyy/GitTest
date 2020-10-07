package LeetCodeSolution;

public class AddTwoNumbers {
    public static ListNode addTwoNumber(ListNode l1 , ListNode l2){
        if(l1 == null || l2 == null) return null;
        ListNode flag = new ListNode(0);
        ListNode head = flag;
        int addOne = 0;

        while(l1 != null || l2 != null || addOne != 0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return  flag.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(4);
        System.out.println(ListNode.print( addTwoNumber(l1,l2)));
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      static String print(ListNode l){
          StringBuilder sb = new StringBuilder();
          while(l != null){
              sb.append(l.val);
              l = l.next;
          }
          return sb.toString();
      }
}
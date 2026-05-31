package Revision.LinkedList;

public class RemoveNthNodeFromEndofList {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(n>0){
            fast = fast.next;
            n--;
        }

        ListNode prevSlow = null;

        while(fast!=null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nextNode = slow.next.next;

        if(prevSlow == null) return head.next;

        prevSlow.next = nextNode;

        return head;
    }
}
}

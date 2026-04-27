package PractiseSets;

public class ReorderList {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head){
        if(head == null) return;

        // find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode tail = slow.next;
        slow.next = null; 
        
        ListNode prev = null;
        ListNode curr = tail;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // merge two linked list into single reordered one
        ListNode l1 = head;
        ListNode l2 = prev;

        while(l1!=null && l2!=null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;

            l1 = temp1;
            l2 = temp2;

        }

    }
}

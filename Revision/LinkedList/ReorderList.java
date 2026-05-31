package Revision.LinkedList;

public class ReorderList {
    static class Solution {
    public void reorderList(ListNode head) {

        // Find middle
ListNode slow = head;
ListNode fast = head;

while (fast.next != null && fast.next.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

// Split into two halves
ListNode headToRev = slow.next;
slow.next = null;

// Reverse second half
ListNode prev = null;

while (headToRev != null) {
    ListNode next = headToRev.next;
    headToRev.next = prev;
    prev = headToRev;
    headToRev = next;
}

// Merge alternately
ListNode first_half = head;
ListNode second_half = prev;

while (second_half != null) {
    ListNode firstNext = first_half.next;
    ListNode secondNext = second_half.next;

    first_half.next = second_half;
    second_half.next = firstNext;

    first_half = firstNext;
    second_half = secondNext;
}
    }
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

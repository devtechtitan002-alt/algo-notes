package Revision.LinkedList;

public class AddTwoNumbers {
    static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        while(l1!=null && l2!=null){
            int value = l1.val + l2.val;
            value += carry;
            temp.next = new ListNode(value%10);
            temp = temp.next;
            carry = value/10;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int value = l1.val;
            value += carry;
            temp.next = new ListNode(value%10);
            temp = temp.next;
            carry = value/10;
            l1=l1.next;
        }

        while(l2!=null){
            int value = l2.val;
            value += carry;
            temp.next = new ListNode(value%10);
            temp = temp.next;
            carry = value/10;
            l2=l2.next;
        } 

        if(carry!=0) temp.next = new ListNode(carry);

        return head.next;
    }
    }
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode buildList(int[] arr){
        if(arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for(int i = 1; i < arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void printList(ListNode head){
        ListNode curr = head;

        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr1 = new int[]{2,4,3};
        int[] arr2 = new int[]{5,6,4};
        ListNode head1 = buildList(arr1);
        ListNode head2 = buildList(arr2);
        printList(head1);
        printList(head2);
        printList(sol.addTwoNumbers(head1,head2));
    }
}

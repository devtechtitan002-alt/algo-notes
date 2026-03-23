public class LinkedListCycle {
    static public class Solution {
    /*
    public boolean hasCycle(ListNode tortoise,ListNode hare){
        if(hare==null || hare.next==null) return false;
        if(tortoise == hare) return true;
        return hasCycle(tortoise.next,hare.next.next);
    }
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //return hasCycle(slow,fast);
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast =  fast.next.next;
            if(slow == fast) return true;
        }
        return false;
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
        ListNode cycle = null;

        for(int i = 1; i < arr.length; i++){
            curr.next = new ListNode(arr[i]);
            if(i==1){ cycle = curr.next; }
            curr = curr.next;
        }
        //curr.next=cycle;

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
        int[] arr = new int[]{3,2,0,-4};
        ListNode head1 = buildList(arr);
        printList(head1);
        System.out.println(sol.hasCycle(head1));
    }
}

public class ReOrderList {
    static class Solution {
    public ListNode getMiddleNode(ListNode tortoise,ListNode hare){
        ListNode prevNode = null;
        while(hare!=null && hare.next!=null){
            prevNode = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return prevNode;
    }
    public ListNode reverseRemainingHalf(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode middleNode = getMiddleNode(slow,fast);
        if(middleNode!=null){
            return;
        }
        ListNode last = reverseRemainingHalf(middleNode.next);
        middleNode.next = last;
        ListNode checker = last;
        ListNode first = head;
        while(first!=null && first.next!=checker){
             ListNode nextFirst = first.next;
             first.next = last;
             ListNode nextLast = last.next;
             last.next = nextFirst;
             first = nextFirst;
             last = nextLast;
        }
        first.next = last;
    }
    /*
    public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    // 🔹 Step 1: Find middle
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 🔹 Step 2: Reverse second half
    ListNode prev = null;
    ListNode curr = slow.next;
    slow.next = null; // IMPORTANT: split the list

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // 🔹 Step 3: Merge two halves
    ListNode first = head;
    ListNode second = prev;

    while (second != null) {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;
    }
}
     */
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
        int[] arr = new int[]{1,2,3,4};
        ListNode head = buildList(arr);
        printList(head);
        sol.reorderList(head);
        printList(head);
    }
}

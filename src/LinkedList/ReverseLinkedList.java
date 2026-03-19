public class ReverseLinkedList {
    static class Solution {
    /*
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    */
   public ListNode reverse(ListNode prev,ListNode curr){
      if(curr.next==null){
         return curr;
      }
      ListNode next=curr.next;
      curr.next=prev;
      prev=curr;
      curr=next;
      return reverse(prev,next);
   }
   public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        return reverse(prev,curr);
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
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = buildList(arr);
        printList(head);
        printList(sol.reverseList(head));
    }
}

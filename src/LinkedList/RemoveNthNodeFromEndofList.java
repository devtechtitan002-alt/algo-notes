public class RemoveNthNodeFromEndofList {
    static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode slow=head;
       ListNode fast=head;
       for(int i=0;i<n;i++){
            fast=fast.next;
       }
       if(fast==null){ // current slow need to remove 
          head = slow.next;   
       }
       while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next;
       }
       ListNode nodeToBeRemove = slow.next;
       if(nodeToBeRemove==null){ return null; }
       ListNode nextNodeAddr = nodeToBeRemove.next;
       slow.next = nextNodeAddr;
       return head;
       /*
       ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode slow = dummy;
ListNode fast = dummy;

for(int i = 0; i <= n; i++){
    fast = fast.next;
}

while(fast != null){
    slow = slow.next;
    fast = fast.next;
}

slow.next = slow.next.next;

return dummy.next;
 */   
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
        ListNode head1 = buildList(arr);
        printList(head1);
        printList(sol.removeNthFromEnd(head1,5));
    }
}

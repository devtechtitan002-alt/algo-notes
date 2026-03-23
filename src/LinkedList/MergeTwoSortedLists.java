public class MergeTwoSortedLists {
    static class Solution {
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode(-1);
        ListNode currNode = resultNode;
        ListNode head1=list1;
        ListNode head2=list2;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                currNode.next=head1;
                currNode=head1;
                head1=head1.next;
            }else{
                currNode.next=head2;
                currNode=head2;
                head2=head2.next;
            }
        }
        if(head1!=null){ currNode.next = head1; }
        if(head2!=null){ currNode.next = head2; }
        //currNode.next = (head1 != null) ? head1 : head2;
        return resultNode.next;
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
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};
        ListNode head1 = buildList(arr1);
        ListNode head2 = buildList(arr2);
        printList(head1);
        printList(head2);
        printList(sol.mergeTwoLists(head1,head2));
    }
}

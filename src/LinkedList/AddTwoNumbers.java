public class AddTwoNumbers {
    static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int sum=0;
        while(l1!=null && l2!=null){
            sum += l1.val+l2.val;
            curr.next = new ListNode(sum%10);
            l1=l1.next;
            l2=l2.next;
            curr = curr.next;
            sum/=10;
        }
        sum = (sum == -1) ? 0 : sum;
        while(l1!=null){
           sum += l1.val;
           curr.next = new ListNode(sum%10);
           sum/=10;
           l1=l1.next;
           curr=curr.next;
        }
        while(l2!=null){
           sum += l2.val;
           curr.next = new ListNode(sum%10);
           sum/=10;
           l2=l2.next;
           curr=curr.next;
        }
        if(sum!=0){
            curr.next=new ListNode(sum);
        }
        return dummyHead.next;
        /*
        ListNode dummy = new ListNode(0);
ListNode curr = dummy;
int carry = 0;

while(l1 != null || l2 != null || carry != 0){
    int sum = carry;
    if(l1 != null){ sum += l1.val; l1 = l1.next; }
    if(l2 != null){ sum += l2.val; l2 = l2.next; }
    carry = sum / 10;
    curr.next = new ListNode(sum % 10);
    curr = curr.next;
}
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
        int[] arr1 = new int[]{9,9,9,9,9,9,9};
        int[] arr2 = new int[]{9,9,9,9};
        ListNode head1 = buildList(arr1);
        ListNode head2 = buildList(arr2);
        printList(head1);
        printList(head2);
        printList(sol.addTwoNumbers(head1,head2));
    }
}

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class MergekSortedLists {
    static class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        Queue<Integer> pq = new PriorityQueue<>();
        for(ListNode heads : lists){
            ListNode curr = heads;
            while(curr!=null){
               pq.add(curr.val);
               curr=curr.next;
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode currDummy = dummyHead;
        int idx=0;
        while(!pq.isEmpty()){
            currDummy.next = new ListNode(pq.poll());
            currDummy = currDummy.next;
        }
        return dummyHead.next;
        */
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int idx=0;
        int n = lists.length;
        int indexTracker = (idx++ % n);
        ListNode resultNode = new ListNode(-1);
        ListNode resultBuilder = resultNode;
        ListNode curr = lists[indexTracker];
        while(curr!=null){
            ListNode nextHead = curr.next;
            curr.next = null;
            pq.add(curr);
            lists[indexTracker] = nextHead;
            if( pq.size() > n){
               resultBuilder.next = new ListNode(pq.poll().val);
               resultBuilder = resultBuilder.next;
            }
            indexTracker = (idx++ % n);
            curr = lists[indexTracker];
        }
        return resultNode.next;
        /*
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a.val, b.val)
);

// Step 1: add all list heads
for (ListNode node : lists) {
    if (node != null) {
        pq.add(node);
    }
}

// Dummy node
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;

// Step 2: process heap
while (!pq.isEmpty()) {
    ListNode minNode = pq.poll();
    
    tail.next = minNode;
    tail = tail.next;

    if (minNode.next != null) {
        pq.add(minNode.next);
    }
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
        int[] arr1 = new int[]{1,4,5};
        int[] arr2 = new int[]{1,3,4};
        int[] arr3 = new int[]{2,6};
        ListNode head1 = buildList(arr1);
        ListNode head2 = buildList(arr2);
        ListNode head3 = buildList(arr3);
        printList(head1);
        printList(head2);
        printList(head3);
        ListNode[] input = { head1 , head2 , head3 };
        printList(sol.mergeKLists(input));
    }
}

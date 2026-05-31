package Revision.LinkedList;
import java.util.PriorityQueue;

public class MergekSortedLists {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // result node
        ListNode result = new ListNode();

        ListNode dummyNode = result;
 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);

        // firsnode all the given n listnodes add to pq here 
        for(ListNode firstNode : lists){
            if(firstNode!=null) pq.add(firstNode);
        }

        while(!pq.isEmpty()){
           ListNode curr = pq.poll();
           ListNode nextNode = curr.next;
           dummyNode.next = curr;
           dummyNode = dummyNode.next;
           if(nextNode!=null) pq.add(nextNode);
        }

        return result.next;
    }
}
}

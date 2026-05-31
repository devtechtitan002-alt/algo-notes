package Revision.LinkedList;
import java.util.PriorityQueue;

public class MergeTwoSortedLists {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        /*
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        if(list1!=null) pq.add(list1);
        if(list2!=null) pq.add(list2);

        while(!pq.isEmpty()){
           ListNode minNode = pq.poll();

           tail.next = minNode;
           tail = tail.next;

           if(minNode.next!=null){
              pq.add(minNode.next);
           }
        }

        return dummy.next;
        */

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1!=null || temp2!=null){
            if(temp1!=null && temp2!=null){
                if(temp1.val < temp2.val){
                   tail.next = temp1;
                   temp1=temp1.next;
                   tail = tail.next;
                }else{
                   tail.next = temp2;
                   temp2=temp2.next;
                   tail = tail.next;
                }
            }
            else if(temp1!=null){
                tail.next = temp1;
                temp1=temp1.next;
                tail = tail.next;
            }else{
                tail.next = temp2;
                temp2=temp2.next;
                tail = tail.next;
            }
        }

        return dummy.next;
    }
}
}

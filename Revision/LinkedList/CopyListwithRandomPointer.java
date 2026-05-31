package Revision.LinkedList;

import org.w3c.dom.Node;

public class CopyListwithRandomPointer {
    static class Solution {
    public Node copyRandomList(Node head) {

        // temp for operations so we can't leave the original node
        Node temp = head;

        // creation of inter-leaving nodes for each nodes
        while(temp!=null){
            Node nextNode = temp.next;
            Node inter_leaves = new Node(temp.val);
            temp.next = inter_leaves;
            inter_leaves.next = nextNode;
            temp = nextNode;
        }

        // copying current random value into inter_leave random respectively
        Node temp1 = head;

        while(temp1!=null && temp1.next!=null){
            temp1.next.random = temp1.random == null ? null : temp1.random.next;
            temp1 = temp1.next.next;
        }

        // separating original and inter-leaving for returning inter-leaving's head
        Node result = new Node(0);
        Node resultNode = result;
        Node temp2 = head;

        while(temp2!=null && temp2.next!=null){
            Node inter_leave = temp2.next;
            Node originalNext = temp2.next.next;
            resultNode.next = inter_leave;
            resultNode = inter_leave;
            temp2.next = originalNext;
            temp2 = temp2.next;
        }

        return result.next;
    }
    }

    static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
}

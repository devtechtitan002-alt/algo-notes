
public class CopyListwithRandomPointer {
    static class Solution {
    class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    }
    public Node copyRandomList(Node head) {
        /*
        Node curr = head;
        Node dummyHead=new Node(0);
        Node dummyMover = dummyHead;
        while(curr.next!=null){
            dummyMover.next = new Node(curr.val);
            dummyMover = dummyMover.next;
            curr = curr.next;
        }
        dummyHead=dummyMover.next;
        Node fixed1 = head;
        Node dynamic1 = head;
        Node fixed2 =dummyHead;
        Node dynamic2 = dummyHead;
        while(fixed1.next!=null){
            dynamic1 = head;
            dynamic2 = dummyHead;
            while(dynamic1!=null){
               if(fixed1.random == null){ 
                fixed2.random = null;
                break;
               }
               if(fixed1.random == dynamic1){ 
                fixed2.random = dynamic2;
                break;
               }
               dynamic1 = dynamic1.next;
               dynamic2 = dynamic2.next;
            }
            fixed1 = fixed1.next;
            fixed2 = fixed2.next;
        }
        return dummyHead;
        */
        Node curr = head;
        while(curr!=null){
            Node currNodeNext = curr.next;
            Node currNodeRandom = curr.random;
            Node copyOfCurrent = new Node(curr.val);
            curr.next = copyOfCurrent;
            copyOfCurrent.next = currNodeNext;
            if(currNodeRandom == null){ copyOfCurrent.random = null; }
            else{
               copyOfCurrent.random = currNodeRandom.next;
            }
            //copyOfCurrent.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }
        Node orig = head;
        Node copyHead = head.next;
        Node copy = copyHead;

        while(orig != null){
           Node origNext = orig.next.next;
           Node copyNext = copy.next != null ? copy.next.next : null;
    
           orig.next = origNext;                      
           copy.next = copyNext;                      
    
           orig = origNext;                          
           copy = copyNext;                          
        }
        return copyHead;
        /*
        if (head == null) return null;

    // 🔹 1st pass: create interleaved copy nodes
    Node curr = head;
    while (curr != null) {
        Node next = curr.next;

        Node copy = new Node(curr.val);
        curr.next = copy;
        copy.next = next;

        curr = next;
    }

    // 🔹 2nd pass: assign random pointers
    curr = head;
    while (curr != null) {
        if (curr.random != null) {
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
    }

    // 🔹 3rd pass: separate original and copied list
    Node orig = head;
    Node copyHead = head.next;
    Node copy = copyHead;

    while (orig != null) {
        orig.next = orig.next.next;

        copy.next = (copy.next != null) ? copy.next.next : null;

        orig = orig.next;
        copy = copy.next;
    }

    return copyHead;
     */
    }
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head == null) return null;
        
        Node ntail = flat(head);
        return head;
    
    }
    
   public Node flat(Node head) {
    
        if(head == null) return null;

        Node p = null;
        Node c = head;

        while(c != null){
            if(c.child == null){
                p = c;
                c = c.next;
            }else{

                Node tail = flat(c.child);
                tail.next = c.next;
                if(c.next != null)
                    c.next.prev = tail;
                c.next = c.child;
                c.child = null;
                c.next.prev = c;

                p = tail;
                c = tail.next;
            }
        }

        return p;
    }
}
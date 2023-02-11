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

	//think of it working in recursion once
    public Node flatten(Node head) {
        flattenTail(head);
        return head;
    }

    //fuck yeah recursion
    public Node flattenTail(Node head){
    	//input head, and it would return tail
    	Node curr = head, prev = null;;

    	while(curr != null){
    		if(curr.child != null){
    			Node nTail = flattenTail(curr.child);

    			//now the child is returned with tail
    			if(curr.next != null){
    				curr.next.prev = nTail;
    			}

    			nTail.next = curr.next;
    			curr.next = curr.child;
    			curr.child.prev = curr;
    			curr.child = null;

    			prev = nTail;
    			curr = nTail.next;
    		}else{
    			prev = curr;
    			curr = curr.next;
    		}
    	}

    }



}
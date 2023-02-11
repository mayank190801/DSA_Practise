/*
// Definition for a Node.
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
*/

class Solution {

	//no space solution for this bad boi should be used! 
	public Node copyRandomList(Node head) {

		//simply insert first 
		Node curr = head;
		while(curr != null){
			Node node = new Node(curr.val);
			node.next = curr.next;
			curr.next = node;
			curr = node.next;
		}

		//after this assign random pointers for sure
		curr = head;
		while(curr != null){
			Node randOriginal = curr.random;
			if(randOriginal != null)
				curr.next.random = randOriginal.next;

			curr = curr.next.next;
		}

		//after this seperate both of them back to original state bois
		Node d = new Node(-1);
		Node fake = d;

		curr = head;

		while(curr != null){
			fake.next = curr.next;
			curr.next = curr.next.next;
			fake = fake.next;
			fake.next = null;
            curr = curr.next;
		}

		return d.next;

	}




	//first using map, in here boi
    public Node copyRandomList(Node head) {
    	//this version works pretty well for sure
    	//no worries about that for sure!! 

    	Map<Node, Node> mapping = new HashMap<>();  //beauty
        Node thead = null;
    	

    	Node curr = head;
    	while(curr != null){
    		Node node = new Node(curr.val);
    		mapping.put(curr, node);
    		curr = curr.next;
    	}

    	curr = head;
    	while(curr != null){
    		Node getp = mapping.get(curr);
    		Node nextp = mapping.get(curr.next);
    		Node randp = mapping.get(curr.random);

    		getp.next = nextp;
    		getp.random = randp;

    		curr = curr.next;
    	}

    	//after this simply connect the head to something
    	thead = mapping.get(head);
    	return thead;
       
    }
}
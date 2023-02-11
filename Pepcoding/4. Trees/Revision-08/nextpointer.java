class Solution {

	//level order is easy as fuck for sure! so skip it bois

	//this below is solved using recursion for sure
	//let's figure out something else for now than!!! (hihihihi)
	//let's trey fucking recursion
     public Node connect(Node root) {
    	if(root == null) return null;
    	if(root.left == null) return root;
    	root.left.next = root.right;

    	helper(root.left);
    	helper(root.right);

    	return root;
    }

    public void helper(Node curr){
    	if(curr.left == null) return;

    	curr.left.next = curr.right;
    	if(curr.next != null){
    		curr.right.next = curr.next.left;
    	}

    	helper(curr.left);
    	helper(curr.right);
    }

    //let's figure this out
    public Node connect(Node root) {
    	if(root == null) return null;
    	if(root.left != null && root.right != null){
    		root.left.next = root.right;
    	}

    	if(root.left != null) helper(root.left);
    	if(root.right != null) helper(root.right);

    	return root;
    }

    public void helper(Node root){
    	if(root == null) return;
    	if(root.left == null && root.right == null) return;

    	if(root.left != null){
    		Node find = finder(root.next);
    		if(root.right != null){
    			root.left.next = root.right;
    			root.right.next = find;
    		}else{
    			root.left.next = find;
    		}
    	}else{
    		Node find = finder(root.next);
    		root.right.next = find;
    	}

    	helper(root.left);
    	helper(root.right);
    }

    public void finder(Node root){
    	if(root == null) return null;
    	while(root != null){
    		if(root.left != null) return root.left;
    		if(root.right != null) return root.right;
    		root = root.next;
    	}

    	return null;
    }

    //finder function is used alag se recursion ke saath for sure, simple and sober technique
	//hmm let's solve this problem and move on!    


    //iterative version boss!
    Node prev = null;
    Node nstart = null;

    public Node connect(Node root) {
    	Node curr = root;

    	while(curr != null){
    		prev = null;
    		nstart = null;

    		while(curr != null){
    			set(curr.left);
    			set(curr.right);
    			curr = curr.next;
    		}

    		curr = nstart;
    	}

    	return root;
    }

    public void set(Node root){
    	if(root == null) return;

    	if(nstart == null){
    		nstart = root;
    	}else{
    		prev.next = root;
    	}

    	prev = root;
    }

    
}






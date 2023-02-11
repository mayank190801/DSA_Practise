class CBTInserter {

	public Queue<TreeNode> que;
	public TreeNode root;

    public CBTInserter(TreeNode root) {
    	//we have recieved a complete binary tree bois
    	this.root = root;

    
    	que = new ArrayDeque<>();
    	que.add(root);

    	while(!que.isEmpty()){
    		int size = que.size();
    		while(size --> 0){
    			TreeNode top = que.peek();
    			if(top.left == null) return;
    			que.add(top.left);

    			if(top.right == null) return;
    			que.poll();
    			que.add(top.right);
    		}
    	}

    }
    
    public int insert(int val) {
    	TreeNode top = que.peek();
    	TreeNode node = new TreeNode(val);

    	if(top.left == null){
    		top.left = node;
    		que.add(node);
    		return top.val;
    	}

    	top.right = node;
    	que.add(node);
    	que.poll();

    	return top.val;
    }
    
    public TreeNode get_root() {
    	return root;
    }

}
class Solution {

	//recursion solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null && q != null) return false;
		if(p != null && q == null) return false;
		if(p.val != q.val) return false;

        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //iterative solution must be figured out boss - let's figure you out baby
    public boolean isSameTree(TreeNode p, TreeNode q) {

    	Queue<TreeNode> que1 = new ArrayDeque<>();
    	Queue<TreeNode> que2 = new ArrayDeque<>();

    	que1.push(p);
    	que2.push(q);

    	while(!que1.isEmpty() && !que2.isEmpty()){
    		if(que1.size() != que2.size()) return false;

    		int size = que1.size();
    		while(size--> 0){

    			TreeNode top1 = que1.poll();
    			TreeNode top2 = que2.poll();

    			if(top1.val != top2.val) return false;

    			if((top1.left == null && top2.left != null) || (top1.right == null && top2.right != null)) return false;
				if((top1.left != null && top2.left == null) || (top1.right != null && top2.right == null)) return false;

				if(top1.left != null){
					que1.push(top1.left);
					que2.push(top2.left);
				}

				if(top1.right != null){
					que1.push(top1.right);
					que2.push(top2.right);	
				}
    		}
    	}

    	return que1.isEmpty() && que2.isEmpty();
    }


}
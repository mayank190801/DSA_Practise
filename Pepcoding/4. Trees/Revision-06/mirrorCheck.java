public class Solution {
	
	//recursive, time limit exceeded error bruh
	public static boolean areMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1 == null && root2 == null) return true;
		if((root1 != null && root2 == null) || (root1 == null && root2 != null ) || root1.data != root2.data) return false;


		return areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left);
	}


	//iterative solution
	public static boolean areMirror(BinaryTreeNode p, BinaryTreeNode q) {

		if(p == null && q == null) return true;
        if(p == null || q == null) return false;

		Queue<BinaryTreeNode> que1 = new ArrayDeque<>();
    	Queue<BinaryTreeNode> que2 = new ArrayDeque<>();

    	que1.add(p);
    	que2.add(q);

    	while(!que1.isEmpty() && !que2.isEmpty()){
    		if(que1.size() != que2.size()) return false;

    		int size = que1.size();
    		while(size--> 0){

    			BinaryTreeNode top1 = que1.poll();
    			BinaryTreeNode top2 = que2.poll();

    			if(top1.val != top2.val) return false;

    			if((top1.left == null && top2.right != null) || (top1.right == null && top2.left != null)) return false;
				if((top1.left != null && top2.right == null) || (top1.right != null && top2.left == null)) return false;

				if(top1.left != null){
					que1.push(top1.left);
					que2.push(top2.right);
				}

				if(top1.right != null){
					que1.push(top1.right);
					que2.push(top2.left);	
				}
    		}
    	}

    	return que1.isEmpty() && que2.isEmpty();
    }

}
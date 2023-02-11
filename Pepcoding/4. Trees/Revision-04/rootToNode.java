public class rootToNode{
	public static void main(String[] args){


	}

	//root to node path
	//compelete recursive one! & with helper to i definitely can solve
	//once found, simply return true, & don't call anything
	public List<Node> rootToNodePath(TreeNode root, int data){
		if(root == null) return new ArrayList<>();

		List<Node> ans = new List<Node>();
		if(root.data == data){
			ans.add(root);
			return ans;
		}


		List<Node> left = rootToNodePath(root.left, data);
		if(left.size() > 0){
			left.add(root);
			return left;
		}

		List<Node> right = rootToNodePath(root.right, data);
		if(right.size() > 0){
			right.add(root);
			return right;
		}

		return ans;
	}

	//root to node distance boys!! (let's think about this oncel)
	public int rootToNodeDistance(TreeNode root, int data){
		if(root == null) return -1;

		if(root.val == data){
			return 1;
		}

		int leftVal = rootToNodeDistance(root.left, data);
		if(leftVal != -1) return leftVal + 1;

		int rightVal = rootToNodeDistance(root.right, data);
		if(rightVal != -1) return rightVal + 1;

		return -1;
	}




}
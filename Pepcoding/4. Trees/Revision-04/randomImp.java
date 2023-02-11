public class randomImp{
	public static void main(String[] args){


	}


	//min finder in a tree //perfect
	public int min(TreeNode node){
		if(node == null) return Integer.MAX_VALUE;
		return Math.min(min(node.left), Math.min(min(node.right), node.val));
	}

	public int size(TreeNode node){
		if(node == null) return 0;
		return size(node.left) + size(node.right) + 1;
	}

	public int height(TreeNode node){
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	//find function baby
	public boolean find(Node root, int search){
		if(root == null) return false;		
		return (root.val == search) || find(root.left) || find(root.right);
	}



}
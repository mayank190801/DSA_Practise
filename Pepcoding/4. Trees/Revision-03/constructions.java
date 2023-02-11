
public class constructions{
	public static void main(String[] args){


	}

	//from pre and in - contruct a tree
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		TreeNode root = buildHelper(preorder, 0, n-1, inorder, 0, n-1);
		return root;
    }

    //after you are done with this, you gotta take some action
    public TreeNode buildHelper(int[] pre, int ps, int pe, int[] inorder, int is, int ie){

    	if(ps > pe) return null;

    	TreeNode node = new TreeNode(pre[ps]);  //root node

    	//find this broski! 
    	int val = pre[ps];

    	int cnt = 0;
    	for(int i = is; i <= ie; i++){
    		if(inorder[i] == val) break;
    		cnt++;
    	}

    	node.left = buildHelper(pre, ps + 1, ps + cnt, inorder, is, is + cnt - 1);
    	node.right = buildeHelper(pre, ps + cnt + 1, pe, inorder, is + cnt + 1, ie); 

    	return node;
    }


    //from in and post - construct a tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildHelper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
    	if(is > ie) return null;

    	TreeNode node = new TreeNode(postorder[pe]);

    	int cnt = 0;
    	for(int i = is; i <= ie; i++){
    		if(postorder[pe] == inorder[i]) break;
    		cnt++;
    	}

    	node.left = buildHelper(inorder, is, is + cnt -1, postorder, ps, ps + cnt - 1);
    	node.right = buildHelper(inorder, is + cnt + 1, ie, postorder, ps + cnt, pe - 1);

    	return node;
    }

    //from post and pre - construct a tree
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int n = postorder.length;
    	for(int i = 0; i < n; i++){
    		map.put(postorder[i], i);
    	}


     	return buildHelper(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildHelper(int[] preorder, int ps, int pe, int[] postorder, int os, int oe, Map<Integer, Integer> map){
    	if(ps > pe) return null;
    	TreeNode node = new TreeNode(preorder[ps]);
    	if(ps == pe) return node;

    	int loc = map.get(preorder[ps + 1]);  //where the game disconnects?
    	int cnt = loc - ps;

    	node.left = buildHelper(preorder, ps + 1, ps + cnt + 1, postorder, os, os + cnt,map);
    	node.right = buildHelper(preorder, ps + cnt + 2, pre, postorder, os + cnt + 1, oe - 1, map);
    	return node;
    }


}

























